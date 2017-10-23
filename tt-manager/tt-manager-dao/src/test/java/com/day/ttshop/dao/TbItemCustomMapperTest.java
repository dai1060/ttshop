package com.day.ttshop.dao;

import com.day.common.dto.Order;
import com.day.common.dto.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao-test.xml")
public class TbItemCustomMapperTest {
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Test
    public void countItems() throws Exception {
//        System.out.println(itemCustomDao.countItems());
    }

    @Test
    public void listItemsByPage() throws Exception {
       /* Page page = new Page();
        page.setPage(1);
        page.setRows(10);
        Order order = new Order();
        order.setOrder("DESC");
        order.setSort("title");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page", page);
        map.put("order", order);
        System.out.println(itemCustomDao.listItemsByPage(map).size());*/
    }

}