package com.jxy.jxyapi.model.form;

import lombok.Data;

/**
 * 商品列表表单
 * Created by lvzhongzhou on 2018/3/17.
 */
@Data
public class GoodsForm {
    // 列表
    public static final String PROFILE_LIST = "list";

    private String categoryId;
}
