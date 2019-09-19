package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SpecificationGroupMapper;
import com.dedu.mall.model.mysql.SpecificationGroupPo;
import com.dedu.mall.model.mysql.SpecificationGroupVo;
import com.dedu.mall.model.mysql.SpecificationPo;
import com.dedu.mall.model.mysql.SpecificationVo;
import com.dedu.mall.service.SpecificationGroupService;
import com.dedu.mall.service.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpecificationGroupSerImpl extends ServiceImpl<SpecificationGroupMapper, SpecificationGroupPo> implements SpecificationGroupService {

    @Autowired
    private SpecificationService specService;

    private Map<Long, List<SpecificationPo>> SPECCACHEMAP = new ConcurrentHashMap<>();

    @Override
    public List<SpecificationGroupVo> queryByCategoryId(Long id) throws Exception {
        // 根据类目Id获取分组信息
        List<SpecificationGroupPo> specGroupList = this.list(new QueryWrapper<SpecificationGroupPo>().eq("category_id", id));
        // 根据分组Id获取规格属性
        if (!CollectionUtils.isEmpty(specGroupList) && SPECCACHEMAP.isEmpty()) {
            // 获取所有的分组Id
            List<Long> groupIdList = specGroupList.stream().map(SpecificationGroupPo::getId).distinct().collect(Collectors.toList());
            List<SpecificationPo> specList = specService.queryByGroupIds(groupIdList);
            // 考虑到数据不对，可进行规格数据缓存
            specList.stream().forEach(t-> {
                if (SPECCACHEMAP.containsKey(t.getGroupId())) {
                    SPECCACHEMAP.get(t.getGroupId()).add(t);
                } else {
                    List<SpecificationPo> specCacheList = new ArrayList<>();
                    specCacheList.add(t);
                    SPECCACHEMAP.put(t.getGroupId(), specCacheList);
                }
            });
        }
        // 进行结果组装
        List<SpecificationGroupVo> result = new ArrayList<>();
        specGroupList.forEach(s->{
            SpecificationGroupVo specGroupVo = new SpecificationGroupVo();
            BeanUtils.copyProperties(s, specGroupVo);
            List<SpecificationVo> specVoList = new ArrayList<>();
            if (SPECCACHEMAP.containsKey(specGroupVo.getId())) {
                List<SpecificationPo> specPoList = SPECCACHEMAP.get(specGroupVo.getId());
                specPoList.stream().forEach(t->{
                    SpecificationVo specVo = new SpecificationVo();
                    BeanUtils.copyProperties(t, specVo);
                    specVoList.add(specVo);
                });
            }
            specGroupVo.setSpecs(specVoList);
            result.add(specGroupVo);
        });
        return result;
    }
}
