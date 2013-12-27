/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact.livelink;

import com.anosym.reddavy.profile.Profile;
import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
public class GCM implements Serializable {

  private static final long serialVersionUID = 7747848931L;
  @Id
  private Long gcmId;
  @NotNull
  private String gcmKey;
  @OneToOne
  @NotNull
  private Profile profile;

  public GCM(String gcmKey, Profile profile) {
    this.gcmKey = gcmKey;
    this.profile = profile;
  }

  public GCM() {
  }

  @PrePersist
  void prePersist() {
    gcmId = IdGenerator.generateId();
  }

  public Long getGcmId() {
    return gcmId;
  }

  public void setGcmId(Long gcmId) {
    this.gcmId = gcmId;
  }

  public String getGcmKey() {
    return gcmKey;
  }

  public void setGcmKey(String gcmKey) {
    this.gcmKey = gcmKey;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + (this.gcmId != null ? this.gcmId.hashCode() : 0);
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
    final GCM other = (GCM) obj;
    if (this.gcmId != other.gcmId && (this.gcmId == null || !this.gcmId.equals(other.gcmId))) {
      return false;
    }
    return true;
  }

}
