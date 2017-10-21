package com.day.ttshop.service;

import com.day.common.dto.Order;
import com.day.common.dto.Page;
import com.day.common.dto.Result;
import com.day.ttshop.pojo.po.TbItem;
import com.day.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

//商品实体类的业务逻辑层
public interface ItemService {
    /*
        按主键查询指定商品
     */
    TbItem getById(Long itemId);

    /*
        不带分页的查询所有商品
     */
    List<TbItem> listItems();

    /*
        带分页的查询所有商品
     */
    Result<TbItemCustom> listItems(Page page, Order order);


    /**
     * 通过商品编号批量修改
     * @param ids
     * @return
     */
    int updateItemsByIds(List<Long> ids);

    int updateUpItemsByIds(List<Long> ids);

    int updateDownItemsByIds(List<Long> ids);
}
