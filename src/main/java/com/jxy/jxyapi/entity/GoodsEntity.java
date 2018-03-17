package com.jxy.jxyapi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * Created by lvzhongzhou on 2018/3/13.
 */
@Data
public class GoodsEntity {
    // 有效状态
    public static final int USER_STATUS_0 = 0; //无效
    public static final int USER_STATUS_1 = 1; //有效

    private Integer goodsId;
    private Integer categoryId;
    private String goodsName;
    private String goodsDesc;
    private String goodsImage;
    private Integer price;
    private String goodsUnit;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
