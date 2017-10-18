package com.day.ttshop.service;

import com.day.ttshop.pojo.po.TbItem;

//商品实体类的业务逻辑层
public interface ItemService {
    TbItem getById(Long itemId);
}
