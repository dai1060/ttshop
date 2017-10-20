package com.day.ttshop.service.impl;

import com.day.common.dto.Page;
import com.day.common.dto.Result;
import com.day.ttshop.dao.TbItemCustomMapper;
import com.day.ttshop.dao.TbItemMapper;
import com.day.ttshop.pojo.po.TbItem;
import com.day.ttshop.pojo.po.TbItemExample;
import com.day.ttshop.pojo.vo.TbItemCustom;
import com.day.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> listItems() {
        return itemDao.selectByExample(null);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page) {
        //通过itemCustomDao获取total和rows
        long total = itemCustomDao.countItems();
        List<TbItemCustom> rows = itemCustomDao.listItemsByPage(page);
        Result<TbItemCustom> rs = new Result<TbItemCustom>();
        rs.setRows(rows);
        rs.setTotal(total);
        return rs;
    }

    @Override
    public int updateItemsByIds(List<Long> ids) {
        //创建商品空对象
        TbItem item = new TbItem();
        item.setStatus((byte)3);
        //下面三行只是准备查询的条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return itemDao.updateByExampleSelective(item,example);
    }

    @Override
    public int updateUpItemsByIds(List<Long> ids) {
        //创建商品空对象
        TbItem item = new TbItem();
        item.setStatus((byte)1);
        //下面三行只是准备查询的条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return itemDao.updateByExampleSelective(item,example);
    }

    @Override
    public int updateDownItemsByIds(List<Long> ids) {
        //创建商品空对象
        TbItem item = new TbItem();
        item.setStatus((byte)2);
        //下面三行只是准备查询的条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return itemDao.updateByExampleSelective(item,example);
    }
}
