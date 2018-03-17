package com.jxy.jxyapi.model.view;

import lombok.Data;

/**
 * 商品视图
 * Created by lvzhongzhou on 2018/3/17.
 */
@Data
public class GoodsView {
    private Integer goodsId;
    private Integer categoryId;
    private String goodsName;
    private String goodsDesc;
    private String goodsImage;
    private String price;
    private String goodsUnit;
}
