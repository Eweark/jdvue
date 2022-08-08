package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TblGoods {
    private int id;
    private String sname;
    private double sprice;
    private int snum;
    private String img;
    private String desc;

}
