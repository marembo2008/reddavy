/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import com.anosym.jflemax.bean.validation.NotEmpty;
import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author marembo
 */
@Entity
public class Contact implements Serializable {

  private static final long serialVersionUID = 188437843L;
  @Id
  private Long contactId = IdGenerator.generateId();
  @OneToOne
  private Address address;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @NotEmpty(message = "You must provide at least one phone number!")
  private List<Phone> phones;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<InstantMessaging> imIds;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Website> websites;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Email> emails;
  @Column(columnDefinition = "TEXT", length = 1048)
  private String contactNotes;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar birthday;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Anniversary> anniversaries;

  public void addAnniversary(Anniversary anniversary) {
    if (this.anniversaries == null) {
      this.anniversaries = new ArrayList<Anniversary>();
    }
    this.anniversaries.add(anniversary);
  }

  public void addWebsite(Website website) {
    if (this.websites == null) {
      this.websites = new ArrayList<Website>();
    }
    this.websites.add(website);
  }

  public void addPhone(Phone phone) {
    if (this.phones == null) {
      this.phones = new ArrayList<Phone>();
    }
    this.phones.add(phone);
  }

  public void addInstantMessaging(InstantMessaging im) {
    if (this.imIds == null) {
      this.imIds = new ArrayList<InstantMessaging>();
    }
    this.imIds.add(im);
  }

  public void addEmail(Email email) {
    if (this.emails == null) {
      this.emails = new ArrayList<Email>();
    }
    this.emails.add(email);
  }

  public void setAnniversaries(List<Anniversary> anniversaries) {
    this.anniversaries = anniversaries;
  }

  public List<Anniversary> getAnniversaries() {
    return anniversaries;
  }

  public void setBirthday(Calendar birthday) {
    this.birthday = birthday;
  }

  public Calendar getBirthday() {
    return birthday;
  }

  public void setContactNotes(String contactNotes) {
    this.contactNotes = contactNotes;
  }

  public String getContactNotes() {
    return contactNotes;
  }

  public List<Website> getWebsites() {
    return websites;
  }

  public void setWebsites(List<Website> websites) {
    this.websites = websites;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setImIds(List<InstantMessaging> imIds) {
    this.imIds = imIds;
  }

  public List<InstantMessaging> getImIds() {
    return imIds;
  }

  public Long getContactId() {
    return contactId;
  }

  public void setContactId(Long contactId) {
    this.contactId = contactId;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + (this.contactId != null ? this.contactId.hashCode() : 0);
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
    final Contact other = (Contact) obj;
    return this.contactId == other.contactId || (this.contactId != null && this.contactId.equals(other.contactId));
  }

}
