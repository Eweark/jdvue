package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Component
public class Tblrolepower {

  private int reId;
  private int roleId;
  private int powerId;

  public int getReId() {
    return reId;
  }

  public void setReId(int reId) {
    this.reId = reId;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public int getPowerId() {
    return powerId;
  }

  public void setPowerId(int powerId) {
    this.powerId = powerId;
  }
}
