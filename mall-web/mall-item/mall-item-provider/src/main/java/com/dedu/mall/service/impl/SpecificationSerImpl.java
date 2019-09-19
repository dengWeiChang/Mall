package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SpecificationMapper;
import com.dedu.mall.model.mysql.SpecificationPo;
import com.dedu.mall.service.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class SpecificationSerImpl extends ServiceImpl<SpecificationMapper, SpecificationPo> implements SpecificationService {


    @Override
    public List<SpecificationPo> queryByGroupIds(List<Long> groupIdList) throws Exception {
        if (CollectionUtils.isEmpty(groupIdList)) {
            throw new Exception("分组Id不能为空");
        }
        return this.list(new QueryWrapper<SpecificationPo>().in("group_id", groupIdList));
    }
}
