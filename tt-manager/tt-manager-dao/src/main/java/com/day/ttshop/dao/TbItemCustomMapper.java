package com.day.ttshop.dao;

import com.day.common.dto.Order;
import com.day.common.dto.Page;
import com.day.ttshop.pojo.po.TbItem;
import com.day.ttshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    //查询所有商品的总记录数
    long countItems();
    //分页查询商品集合
//    List<TbItemCustom> listItemsByPage(@Param("page") Page page, @Param("order") Order order);
    List<TbItemCustom> listItemsByPage(Map<String,Object> map);
}
