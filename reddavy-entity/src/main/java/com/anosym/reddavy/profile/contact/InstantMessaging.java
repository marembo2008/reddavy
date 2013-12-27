/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.reddavy.profile.util.IMType;
import com.anosym.utilities.IdGenerator;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marembo
 */
@Entity
@Table(uniqueConstraints = {
  @UniqueConstraint(columnNames = {"im", "imType"})})
public class InstantMessaging implements Serializable {

  private static final long serialVersionUID = 454540281L;
  @Id
  private Long imId = IdGenerator.generateId();
  @NotNull
  private String im;
  @NotNull
  private IMType imType;

  public Long getImId() {
    return imId;
  }

  public void setImId(Long imId) {
    this.imId = imId;
  }

  public String getIm() {
    return im;
  }

  public void setIm(String im) {
    this.im = im;
  }

  public IMType getImType() {
    return imType;
  }

  public void setImType(IMType imType) {
    this.imType = imType;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 41 * hash + (this.imId != null ? this.imId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final InstantMessaging other = (InstantMessaging) obj;
    return this.imId == other.imId || (this.imId != null && this.imId.equals(other.imId));
  }

}
