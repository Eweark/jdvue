package com.cykj.service;

import com.cykj.bean.TbGoods;

import java.util.List;

public interface TbGoodsService {
    int addGoods(TbGoods tbGoods);

    //根据商品名称查询相关信息
    String seGoods(String sname);
    //查询全部商品
    List<TbGoods> selAllGoods();
}
