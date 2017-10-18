package com.day.ttshop.service.impl;

import com.day.ttshop.dao.TbItemMapper;
import com.day.ttshop.pojo.po.TbItem;
import com.day.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }
}
