package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo {
    @NotNull
    private Long categoryId;
    @NotNull
    private Long brand;
    @NotEmpty
    private String packlist;
    @NotEmpty
    private String service;
    @NotEmpty
    private String name;
    @NotEmpty
    private String subtitle;
    private String desc;
    // 富文本
    private String detailPicture;
    private List<SpecReqVo> specs;
    private List<PriceReqVo> prices;
    private List<PictureReqVo> pictures;

}
