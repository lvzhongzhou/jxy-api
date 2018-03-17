package com.jxy.jxyapi.controller;

import com.jxy.jxyapi.config.ValidationProfiles;
import com.jxy.jxyapi.model.form.GoodsForm;
import com.jxy.jxyapi.model.view.GoodsView;
import com.jxy.jxyapi.service.GoodsService;
import com.jxy.jxyapi.util.BusinessResult;
import com.jxy.jxyapi.util.BusinessResultBase;
import com.jxy.jxyapi.util.BusinessResultCode;
import com.jxy.jxyapi.util.IBusinessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品控制器
 * Created by lvzhongzhou on 2018/3/13.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "track.jsp")
    public String track() {
        return "ok";
    }

    /**
     * 用户列表
     *
     * @return BusinessResult
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ValidationProfiles(profiles = GoodsForm.PROFILE_LIST)
    public IBusinessResult list(GoodsForm goodsForm) {
        try {
            List<GoodsView> goodsViewList = goodsService.getGoodsList(goodsForm);
            return new BusinessResult(BusinessResultCode.SUCCESS, "商品列表查询成功！", goodsViewList);
        } catch (Exception e) {
            log.error("商品列表查询失败：", e);
            return new BusinessResultBase(BusinessResultCode.EXCEPTION, "商品列表查询失败!");
        }
    }

}
