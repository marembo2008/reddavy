/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.reddavy.profile.util.PhoneType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author marembo
 */
@Entity
public class Phone implements Serializable {

  private static final long serialVersionUID = 14545544L;
  @Id
  @Column(length = 20)
  private String phoneNumber;
  @NotNull
  private PhoneType phoneType;
  private boolean defaultPhone;

  public void setDefaultPhone(boolean defaultPhone) {
    this.defaultPhone = defaultPhone;
  }

  public boolean isDefaultPhone() {
    return defaultPhone;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public PhoneType getPhoneType() {
    return phoneType;
  }

  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + (this.phoneNumber != null ? this.phoneNumber.hashCode() : 0);
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
    final Phone other = (Phone) obj;
    return !((this.phoneNumber == null) ? (other.phoneNumber != null) : !this.phoneNumber.equals(other.phoneNumber));
  }

}
