package com.cykj.mapper;

import com.cykj.bean.TbGoods;
import org.springframework.stereotype.Repository;

@Repository
public interface TbGoodsMapper {
    int addGoods(TbGoods tbGoods);
}
