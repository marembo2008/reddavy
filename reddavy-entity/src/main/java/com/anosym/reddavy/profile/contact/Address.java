/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.jflemax.jpa.eclipselink.converter.CountryCodeEclipseLinkJpaConverter;
import com.anosym.utilities.IdGenerator;
import com.anosym.utilities.geocode.CountryCode;
import java.io.Serializable;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author marembo
 */
@Entity
public class Address implements Serializable {

  private static final long serialVersionUID = 8484741L;
  @Id
  private Long addressId = IdGenerator.generateId();
  private String address;
  @Convert(converter = CountryCodeEclipseLinkJpaConverter.class)
  private CountryCode country;
  private String provinceOrState;
  private String city;
  private String zipCode; //can also be postal code

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CountryCode getCountry() {
    return country;
  }

  public void setCountry(CountryCode country) {
    this.country = country;
  }

  public String getProvinceOrState() {
    return provinceOrState;
  }

  public void setProvinceOrState(String provinceOrState) {
    this.provinceOrState = provinceOrState;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + (this.addressId != null ? this.addressId.hashCode() : 0);
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
    final Address other = (Address) obj;
    return this.addressId == other.addressId || (this.addressId != null && this.addressId.equals(other.addressId));
  }

}
