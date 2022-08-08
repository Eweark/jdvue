package com.cykj.service.impl;

import com.cykj.bean.TbGoods;
import com.cykj.mapper.TbGoodsMapper;
import com.cykj.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Override
    public int addGoods(TbGoods tbGoods) {
        int re=tbGoodsMapper.addGoods(tbGoods);
        return  re;
    }
}
