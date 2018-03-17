package com.jxy.jxyapi.service;

import com.jxy.jxyapi.entity.GoodsEntity;
import com.jxy.jxyapi.mapper.GoodsMapper;
import com.jxy.jxyapi.model.form.GoodsForm;
import com.jxy.jxyapi.model.view.GoodsView;
import com.jxy.jxyapi.util.NumberFormats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务类
 * Created by lvzhongzhou on 2018/3/17.
 */
@Slf4j
@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 商品列表
     *
     * @param goodsForm 商品表单
     * @return List
     */
    public List<GoodsView> getGoodsList(GoodsForm goodsForm) {
        //查询商品列表
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsId(Integer.valueOf(goodsForm.getCategoryId()));
        goodsEntity.setStatus(GoodsEntity.USER_STATUS_1);
        List<GoodsEntity> goodsEntityList = goodsMapper.queryGoodsList(goodsEntity);
        //转化商品视图
        List<GoodsView> goodsViewList = new ArrayList<>();
        for (GoodsEntity entity : goodsEntityList) {
            GoodsView view = new GoodsView();
            view.setGoodsId(entity.getGoodsId());
            view.setCategoryId(entity.getCategoryId());
            view.setGoodsName(entity.getGoodsName());
            view.setGoodsDesc(entity.getGoodsDesc());
            view.setGoodsImage(entity.getGoodsImage());
            view.setPrice(NumberFormats.formatPercentage(entity.getPrice()));
            view.setGoodsUnit(entity.getGoodsUnit());
            goodsViewList.add(view);
        }
        return goodsViewList;
    }
}
