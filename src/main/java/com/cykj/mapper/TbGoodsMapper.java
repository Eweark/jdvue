package com.cykj.mapper;

import com.cykj.bean.TbGoods;
import com.cykj.bean.Tblstaff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsMapper {
    int addGoods(TbGoods tbGoods);

    //根据商品名称查询相关信息
    List<TbGoods> seGoods(@Param("sname") String sname);

    //查询用户
    List<TbGoods> selAllGoods();

    //修改商品
    int updateGoods(@Param("sname")String sname,
                    @Param("sprice")String sprice,
                    @Param("snum")int snum,
                    @Param("img")String img,
                    @Param("desc")String desc);
}
