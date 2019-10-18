package com.dedu.mall.service.impl;

import com.dedu.mall.enums.SpecialType;
import com.dedu.mall.model.mysql.SpecialDetailVo;
import com.dedu.mall.model.mysql.SpecialItemVo;
import com.dedu.mall.model.mysql.SpecialVo;
import com.dedu.mall.service.SpecialService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 专栏服务
 */
@Service
public class SpecialSerImpl implements SpecialService {

    @Override
    public SpecialVo getSpecialByType(int type) {
        if (Objects.equals(SpecialType.COMPUTER.getType(), type)) {
            String title = "电脑专栏";
            String[] linkArr = {"电脑馆", "游戏极品", "装机大师", "职场焕新", "女神频道", "虚拟现实", "二合一平板", "电子教育", "万物周刊"};
            List<String> link = Arrays.asList(linkArr);
            List<SpecialDetailVo> detail = new ArrayList<>();

            List<SpecialItemVo> itemFour = new ArrayList<>();
            itemFour.add(SpecialItemVo.builder().title("电脑馆").intro("笔记本999元限量秒！").img("static/img/index/computer/item-computer-2.jpg").build());
            itemFour.add(SpecialItemVo.builder().title("外设装备").intro("1000减618").img("static/img/index/computer/item-computer-1-3.jpg").build());
            itemFour.add(SpecialItemVo.builder().title("电脑配件").intro("联合满减最高省618").img("static/img/index/computer/item-computer-1-4.jpg").build());
            itemFour.add(SpecialItemVo.builder().title("办公生活").intro("5折神券 精品文具").img("static/img/index/computer/item-computer-1-5.jpg").build());
            String[] itemContentArr = {"static/img/index/computer/item-computer-1-6.jpg", "static/img/index/computer/item-computer-1-7.jpg", "static/img/index/computer/item-computer-1-8.jpg"};
            List<String> itemContent = Arrays.asList(itemContentArr);
            SpecialDetailVo detailOne = SpecialDetailVo.builder()
                    .bigImg("static/img/index/computer/item-computer-1.jpg")
                    .itemFour(itemFour)
                    .itemContent(itemContent)
                    .build();
            detail.add(detailOne);


            List<SpecialItemVo> itemFour2 = new ArrayList<>();
            itemFour2.add(SpecialItemVo.builder().title("电脑馆").intro("笔记本999元限量秒！").img("static/img/index/computer/item-computer-2.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("外设装备").intro("1000减618").img("static/img/index/computer/item-computer-1-3.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("电脑配件").intro("联合满减最高省618").img("static/img/index/computer/item-computer-1-4.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("办公生活").intro("5折神券 精品文具").img("static/img/index/computer/item-computer-1-5.jpg").build());
            String[] itemContent2Arr2 = {"static/img/index/computer/item-computer-1-6.jpg", "static/img/index/computer/item-computer-1-7.jpg", "static/img/index/computer/item-computer-1-8.jpg"};
            List<String> itemContent2 = Arrays.asList(itemContent2Arr2);
            SpecialDetailVo detailTwo = SpecialDetailVo.builder()
                    .bigImg("static/img/index/computer/item-computer-1.jpg")
                    .itemFour(itemFour2)
                    .itemContent(itemContent2)
                    .build();
            detail.add(detailTwo);

            SpecialVo specialVo = SpecialVo.builder().title(title).link(link).detail(detail).build();
            return specialVo;
        } else if (Objects.equals(SpecialType.EAT.getType(), type)){
            String title = "吃货";
            String[] linkArr = {"休闲零食", "坚果", "牛奶", "饮料冲调", "食用油", "大米", "白酒", "红酒", "烧烤食材", "牛排", "樱桃"};
            List<String> link = Arrays.asList(linkArr);
            List<SpecialDetailVo> detail = new ArrayList<>();

            List<SpecialItemVo> itemFour = new ArrayList<>();
            itemFour.add(SpecialItemVo.builder().title("粮油调味").intro("买2免1").img("static/img/index/eat/item-eat-1-2.jp").build());
            itemFour.add(SpecialItemVo.builder().title("饮料冲调").intro("第二件半价").img("static/img/index/eat/item-eat-1-3.jpg").build());
            itemFour.add(SpecialItemVo.builder().title("休闲零食").intro("满99减40").img("static/img/index/eat/item-eat-1-4.jpg").build());
            itemFour.add(SpecialItemVo.builder().title("中外名酒").intro("满199减100").img("static/img/index/eat/item-eat-1-5.jpg").build());
            String[] itemContentArr = {"static/img/index/eat/item-eat-1-6.jpg",  "static/img/index/eat/item-eat-1-7.jpg", "static/img/index/eat/item-eat-1-8.jpg"};
            List<String> itemContent = Arrays.asList(itemContentArr);
            SpecialDetailVo detailOne = SpecialDetailVo.builder()
                    .bigImg("static/img/index/eat/item-eat-1-1.jpg")
                    .itemFour(itemFour)
                    .itemContent(itemContent)
                    .build();
            detail.add(detailOne);


            List<SpecialItemVo> itemFour2 = new ArrayList<>();
            itemFour2.add(SpecialItemVo.builder().title("东家菜").intro("丰富好味").img("static/img/index/eat/item-eat-2-2.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("东家菜").intro("丰富好味").img("static/img/index/eat/item-eat-2-2.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("东家菜").intro("丰富好味").img("static/img/index/eat/item-eat-2-2.jpg").build());
            itemFour2.add(SpecialItemVo.builder().title("东家菜").intro("丰富好味").img("static/img/index/eat/item-eat-2-2.jpg").build());
            String[] itemContentArr2 = {"static/img/index/eat/item-eat-2-6.jpg",  "static/img/index/eat/item-eat-2-7.jpg", "static/img/index/eat/item-eat-2-8.jpg"};
            List<String> itemContent2 = Arrays.asList(itemContentArr2);
            SpecialDetailVo detailTwo = SpecialDetailVo.builder()
                    .bigImg("static/img/index/computer/item-computer-1.jpg")
                    .itemFour(itemFour2)
                    .itemContent(itemContent2)
                    .build();
            detail.add(detailTwo);

            SpecialVo specialVo = SpecialVo.builder().title(title).link(link).detail(detail).build();
            return specialVo;
        } else {
            return null;
        }
    }
}
