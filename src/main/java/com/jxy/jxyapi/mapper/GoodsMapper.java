package com.jxy.jxyapi.mapper;

import com.jxy.jxyapi.entity.GoodsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品 Mapper
 * Created by lvzhongzhou on 2018/3/17.
 */
@Component(value = "goodsMapper")
public interface GoodsMapper {
    /**
     * 查询某类别的商品列表
     *
     * @param goodsEntity 商品实体
     * @return List
     */
    List<GoodsEntity> queryGoodsList(GoodsEntity goodsEntity);

}
