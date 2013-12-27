/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.contact;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
public class Anniversary implements Serializable {

  private static final long serialVersionUID = 4924892421L;
  @Id
  private Long anniversaryId;
  @NotNull
  private String anniversaryName;
  @Temporal(javax.persistence.TemporalType.DATE)
  @NotNull
  private Calendar anniversaryDate;
  @Column(columnDefinition = "TEXT", length = 2000)
  private String anniversaryNotes;

  public Long getAnniversaryId() {
    return anniversaryId;
  }

  public void setAnniversaryId(Long anniversaryId) {
    this.anniversaryId = anniversaryId;
  }

  public String getAnniversaryName() {
    return anniversaryName;
  }

  public void setAnniversaryName(String anniversaryName) {
    this.anniversaryName = anniversaryName;
  }

  public Calendar getAnniversaryDate() {
    return anniversaryDate;
  }

  public void setAnniversaryDate(Calendar anniversaryDate) {
    this.anniversaryDate = anniversaryDate;
  }

  public void setAnniversaryNotes(String anniversaryNotes) {
    this.anniversaryNotes = anniversaryNotes;
  }

  public String getAnniversaryNotes() {
    return anniversaryNotes;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + (this.anniversaryId != null ? this.anniversaryId.hashCode() : 0);
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
    final Anniversary other = (Anniversary) obj;
    return this.anniversaryId == other.anniversaryId || (this.anniversaryId != null && this.anniversaryId.equals(other.anniversaryId));
  }

}
