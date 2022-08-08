package com.cykj.service.impl;

import com.cykj.bean.TblGoods;
import com.cykj.mapper.TbGoodsMapper;
import com.cykj.service.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Override
    public int addGoods(TblGoods tblGoods) {
        int re=tbGoodsMapper.addGoods(tblGoods);
        return  re;
    }
}
