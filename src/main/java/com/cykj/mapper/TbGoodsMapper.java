package com.cykj.mapper;

import com.cykj.bean.TbGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsMapper {
    int addGoods(TbGoods tbGoods);

    //根据商品名称查询相关信息
    List<TbGoods> seGoods(@Param("sname") String sname);

}
