/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact.livelink;

import com.anosym.reddavy.profile.Profile;
import com.anosym.reddavy.profile.contact.Contact;
import com.anosym.reddavy.profile.contact.livelink.util.LivelinkRequestStatus;
import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
@Table(uniqueConstraints = {
  @UniqueConstraint(columnNames = {"fromProfile_profileId", "toProfile_profileId"})
})
@NamedQueries({
  @NamedQuery(name = "LivelinkRequest.find_livelink_requests",
          query = "SELECT lr FROM LivelinkRequest lr WHERE lr.toProfile.profileId = :profileId AND lr.requestStatus = :requestStatus")
})
public class LivelinkRequest implements Serializable {

  private static final long serialVersionUID = 4998959651L;
  @Id
  private Long requestId;
  @ManyToOne
  @NotNull
  private Profile fromProfile;
  @ManyToOne
  @NotNull
  private Profile toProfile;
  /**
   * Not null if the request was made from an existing contact.
   */
  @ManyToOne
  private Contact contact;
  private LivelinkRequestStatus requestStatus;
  private String requestMessage;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar requestDate;

  public LivelinkRequest() {
  }

  public LivelinkRequest(Profile fromProfile, Profile toProfile, Contact contact, LivelinkRequestStatus requestStatus, String requestMessage) {
    this.fromProfile = fromProfile;
    this.toProfile = toProfile;
    this.contact = contact;
    this.requestStatus = requestStatus;
    this.requestMessage = requestMessage;
  }

  @PrePersist
  void preInit() {
    requestDate = Calendar.getInstance();
    requestId = IdGenerator.generateId();
  }

  public Calendar getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(Calendar requestDate) {
    this.requestDate = requestDate;
  }

  public Long getRequestId() {
    return requestId;
  }

  public void setRequestId(Long requestId) {
    this.requestId = requestId;
  }

  public Profile getFromProfile() {
    return fromProfile;
  }

  public void setFromProfile(Profile fromProfile) {
    this.fromProfile = fromProfile;
  }

  public Profile getToProfile() {
    return toProfile;
  }

  public void setToProfile(Profile toProfile) {
    this.toProfile = toProfile;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public LivelinkRequestStatus getRequestStatus() {
    return requestStatus;
  }

  public void setRequestStatus(LivelinkRequestStatus requestStatus) {
    this.requestStatus = requestStatus;
  }

  public String getRequestMessage() {
    return requestMessage;
  }

  public void setRequestMessage(String requestMessage) {
    this.requestMessage = requestMessage;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + (this.requestId != null ? this.requestId.hashCode() : 0);
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
    final LivelinkRequest other = (LivelinkRequest) obj;
    if (this.requestId != other.requestId && (this.requestId == null || !this.requestId.equals(other.requestId))) {
      return false;
    }
    return true;
  }

}
