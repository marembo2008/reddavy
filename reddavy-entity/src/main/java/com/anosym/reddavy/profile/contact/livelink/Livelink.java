/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact.livelink;

import com.anosym.reddavy.profile.contact.Contact;
import com.anosym.reddavy.profile.contact.livelink.util.LivelinkStatus;
import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marembo
 */
@Entity
@Table(uniqueConstraints = {
  @UniqueConstraint(columnNames = {"contact_contactId", "livelinkedContact_contactId"})
})
@NamedQueries({
  @NamedQuery(name = "Livelink.check_contact_livelink",
          query = "SELECT COUNT(l) FROM Livelink l WHERE l.contact.contactId = :contactId AND l.livelinkedContact.contactId = :livelinkContactId")})
public class Livelink implements Serializable {

  private static final long serialVersionUID = 27473431L;
  @Id
  @Column(length = 20)
  private String livelinkId;
  @ManyToOne
  private Contact contact;
  @ManyToOne
  private Contact livelinkedContact;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar createdDate;
  private LivelinkStatus livelinkStatus;

  @PrePersist
  void preInit() {
    livelinkStatus = LivelinkStatus.ACTIVE;
    createdDate = Calendar.getInstance();
    livelinkId = IdGenerator.generateTimeBasedId(8);
  }

  public String getLivelinkId() {
    return livelinkId;
  }

  public void setLivelinkId(String livelinkId) {
    this.livelinkId = livelinkId;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Contact getLivelinkedContact() {
    return livelinkedContact;
  }

  public void setLivelinkedContact(Contact livelinkedContact) {
    this.livelinkedContact = livelinkedContact;
  }

  public Calendar getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }

  public LivelinkStatus getLivelinkStatus() {
    return livelinkStatus;
  }

  public void setLivelinkStatus(LivelinkStatus livelinkStatus) {
    this.livelinkStatus = livelinkStatus;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (this.livelinkId != null ? this.livelinkId.hashCode() : 0);
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
    final Livelink other = (Livelink) obj;
    return !((this.livelinkId == null) ? (other.livelinkId != null) : !this.livelinkId.equals(other.livelinkId));
  }

}
