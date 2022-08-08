package com.cykj.controller;


import com.cykj.bean.TbGoods;
import com.cykj.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/addGoodsPage",produces = "application/json;charset=UTF-8")
    public String addGoodsPage(){
        return "addGood ";
    }

    @RequestMapping("/addGoods")
    public int addGoods(TbGoods tbGoods){
        int re=tbGoodsService.addGoods(tbGoods);
        return  re;
    }


}
