package com.day.ttshop.dao;

import com.day.common.dto.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao-test.xml")
public class TbItemCustomMapperTest {
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Test
    public void countItems() throws Exception {
        System.out.println(itemCustomDao.countItems());
    }

    @Test
    public void listItemsByPage() throws Exception {
        Page page = new Page();
        page.setPage(1);
        page.setRows(10);
        System.out.println(itemCustomDao.listItemsByPage(page).size());
    }

}