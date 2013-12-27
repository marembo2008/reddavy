/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile;

import com.anosym.jflemax.jpa.eclipselink.converter.CountryCodeEclipseLinkJpaConverter;
import com.anosym.utilities.geocode.CountryCode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
public class SimCard implements Serializable {

  private static final long serialVersionUID = 17385385739L;
  /**
   * This represents the current simcard where the user is locked.
   */
  @Id
  @Column(length = 20)
  private String msisdn;
  @Column(length = 50, unique = true)
  private String simSerialNumber;
  @Column(length = 50, unique = true)
  private String subscriberId;
  @Convert(converter = CountryCodeEclipseLinkJpaConverter.class)
  private CountryCode simCountry;
  @NotNull
  @ManyToOne
  private Profile profile;

  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public String getSimSerialNumber() {
    return simSerialNumber;
  }

  public void setSimSerialNumber(String simSerialNumber) {
    this.simSerialNumber = simSerialNumber;
  }

  public String getSubscriberId() {
    return subscriberId;
  }

  public void setSubscriberId(String subscriberId) {
    this.subscriberId = subscriberId;
  }

  public CountryCode getSimCountry() {
    return simCountry;
  }

  public void setSimCountry(CountryCode simCountry) {
    this.simCountry = simCountry;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + (this.msisdn != null ? this.msisdn.hashCode() : 0);
    hash = 79 * hash + (this.simSerialNumber != null ? this.simSerialNumber.hashCode() : 0);
    hash = 79 * hash + (this.subscriberId != null ? this.subscriberId.hashCode() : 0);
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
    final SimCard other = (SimCard) obj;
    if ((this.msisdn == null) ? (other.msisdn != null) : !this.msisdn.equals(other.msisdn)) {
      return false;
    }
    if ((this.simSerialNumber == null) ? (other.simSerialNumber != null) : !this.simSerialNumber.equals(other.simSerialNumber)) {
      return false;
    }
    return !((this.subscriberId == null) ? (other.subscriberId != null) : !this.subscriberId.equals(other.subscriberId));
  }

}
