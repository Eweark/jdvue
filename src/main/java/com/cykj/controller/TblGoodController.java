package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.TbGoods;
import com.cykj.service.TbGoodsService;
import com.cykj.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@Api(value = "接口说明",tags = "商品查询")
public class TblGoodController {
    @Autowired
    private UserService userService;
    @Autowired
    private TbGoodsService tbGoodsService;

    @RequestMapping("/selAllGoods")
    public @ResponseBody
    String sel(){
        List<TbGoods> userList = tbGoodsService.selAllGoods();
        Map<String,Object> map=new HashMap<>();
        map.put("list",userList);
        String json= JSON.toJSONString(map);
        return json;
    }
}
