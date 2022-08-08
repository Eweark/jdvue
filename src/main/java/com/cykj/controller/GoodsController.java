package com.cykj.controller;

import com.cykj.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName: jdvue
 * Package:  com.cykj.controller
 * ClassName:   GoodsController
 * Author:   Mr.lm
 * Description:  description
 * Date:   2022/8/8  17:57
 * Version:   1.0
 */
@RestController
@RequestMapping("/admin")
public class GoodsController {

    @Autowired
    private TbGoodsService tbGoodsService;


    @RequestMapping(value = "/goods",produces = "application/json;charset=UTF-8")
    public String seGoods(String sname){
        String seGoods = tbGoodsService.seGoods(sname);
        return  seGoods;
    };

}
