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
public class ContactGroup implements Serializable {

  private static final long serialVersionUID = 4587155881L;
  @Id
  private Long groupId;
  @NotNull(message = "You must provide the group name!")
  @Column(length = 30)
  private String name;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Contact> contacts;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar createdDate;

  @PrePersist
  void preInit() {
    createdDate = Calendar.getInstance();
    groupId = IdGenerator.generateId();
  }

  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }

  public Calendar getCreatedDate() {
    return createdDate;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + (this.groupId != null ? this.groupId.hashCode() : 0);
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
    final ContactGroup other = (ContactGroup) obj;
    return this.groupId == other.groupId || (this.groupId != null && this.groupId.equals(other.groupId));
  }

}
