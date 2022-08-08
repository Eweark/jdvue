package com.cykj.mapper;

import com.cykj.bean.TblGoods;
import org.springframework.stereotype.Repository;

@Repository
public interface TbGoodsMapper {
    int addGoods(TblGoods tbGoods);
}
