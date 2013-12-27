/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.reddavy.profile.util.AddressType;
import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
public class Website implements Serializable {

  private static final long serialVersionUID = 1748482429L;
  @Id
  private Long websiteId;
  @Column(unique = true, length = 20)
  @NotNull
  private String url;
  @NotNull
  private AddressType type;
  @Column(length = 1048)
  private String description;

  @PrePersist
  void preInit() {
    websiteId = IdGenerator.generateId();
  }

  public Long getWebsiteId() {
    return websiteId;
  }

  public void setWebsiteId(Long websiteId) {
    this.websiteId = websiteId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AddressType getType() {
    return type;
  }

  public void setType(AddressType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
