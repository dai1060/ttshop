package com.day.ttshop.web;


import com.day.common.dto.Page;
import com.day.common.dto.Result;
import com.day.ttshop.pojo.po.TbItem;
import com.day.ttshop.pojo.vo.TbItemCustom;
import com.day.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//商品控制层代码
@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable Long itemId){
        System.out.println(itemId);
        return itemService.getById(itemId);
    }

/*    @ResponseBody
    @RequestMapping("/items")
    public List<TbItem> listItems(){
        return itemService.listItems();
    }*/

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItems(Page page){
        return itemService.listItems(page);
    }


}
