/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.utilities.IdGenerator;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

/**
 *
 * @author marembo
 */
@Entity
public class PhoneBook implements Serializable {

  private static final long serialVersionUID = 30387366341L;
  @Id
  private Long phoneBookId = IdGenerator.generateId();
  @NotNull(message = "You must provide the phone book name")
  @Column(length = 30)
  private String name;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar createdDate;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<ContactGroup> contactGroups;

  @PrePersist
  void preInit() {
    createdDate = Calendar.getInstance();
    phoneBookId = IdGenerator.generateId();
  }

  public Long getPhoneBookId() {
    return phoneBookId;
  }

  public void setPhoneBookId(Long phoneBookId) {
    this.phoneBookId = phoneBookId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Calendar getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }

  public List<ContactGroup> getContactGroups() {
    return contactGroups;
  }

  public void setContactGroups(List<ContactGroup> contactGroups) {
    this.contactGroups = contactGroups;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + (this.phoneBookId != null ? this.phoneBookId.hashCode() : 0);
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
    final PhoneBook other = (PhoneBook) obj;
    return this.phoneBookId == other.phoneBookId || (this.phoneBookId != null && this.phoneBookId.equals(other.phoneBookId));
  }

}
