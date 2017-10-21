package com.day.ttshop.pojo.vo;

import com.day.ttshop.pojo.po.TbItem;
//商品对应页面的实体类
public class TbItemCustom extends TbItem {
    //显示分类的名称
    private String catName;

    private String priceView;

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
