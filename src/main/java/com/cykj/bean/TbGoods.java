package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TbGoods {
    private int id;
    private String sname;
    private double sprice;
    private int snum;
    private String img;
    private String sdesc;

    public TbGoods(String sname, double sprice, int snum, String img, String sdesc) {
        this.sname = sname;
        this.sprice = sprice;
        this.snum = snum;
        this.img = img;
        this.sdesc = sdesc;
    }
}
