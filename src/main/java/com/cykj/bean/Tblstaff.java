package com.cykj.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel("用户实体类")
public class Tblstaff {
  @ApiModelProperty(value = "用户ID")
  private int staffId;
  @ApiModelProperty(value = "用户账号")
  private String acc;
  private String pwd;
  private int roleId;
  private String name;
  private String address;
  private int age;
  private String headImg;

  private int currentPage;
  private int pageSize;



}
