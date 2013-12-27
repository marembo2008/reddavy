/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile;

import com.anosym.utilities.IdGenerator;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marembo
 */
@Entity
public class Profile implements Serializable {

  private static final long serialVersionUID = 3902836641L;
  @Id
  private Long profileId;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Calendar registrationDate;
  private String organization;
  /**
   * Represents the url to this image. A separate request should be made to get the profile image if
   * need be.
   */
  private String profileImage;
  @NotNull(message = "Surname must be provided!")
  private String surname;
  @NotNull(message = "First name must be provided!")
  private String firstName;
  private String lastName;
  private String title;

  @PrePersist
  void preInit() {
    registrationDate = Calendar.getInstance();
    profileId = IdGenerator.generateId();
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }

  public String getProfileImage() {
    return profileImage;
  }

  public Long getProfileId() {
    return profileId;
  }

  public void setProfileId(Long profileId) {
    this.profileId = profileId;
  }

  public Calendar getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Calendar registrationDate) {
    this.registrationDate = registrationDate;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (this.profileId != null ? this.profileId.hashCode() : 0);
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
    final Profile other = (Profile) obj;
    return this.profileId == other.profileId || (this.profileId != null && this.profileId.equals(other.profileId));
  }

}
