package com.cykj.service.impl;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.TbGoods;
import com.cykj.mapper.TbGoodsMapper;
import com.cykj.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Override
    public int addGoods(TbGoods tbGoods) {
        int re=tbGoodsMapper.addGoods(tbGoods);
        return  re;
    }

    //根据商品名称查询相关信息
    @Override
    public String seGoods(String sname) {
        List<TbGoods> seGoods = tbGoodsMapper.seGoods(sname);
        String msg = "";
        if(seGoods!=null){
            msg = JSON.toJSONString(seGoods);
        }
        return msg;
    }
}
