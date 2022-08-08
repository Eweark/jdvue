package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Tblpower {

  private int powerId;
  private String powerName;
  private String url;
  private int parentId;

  public int getPowerId() {
    return powerId;
  }

  public void setPowerId(int powerId) {
    this.powerId = powerId;
  }

  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }
}
