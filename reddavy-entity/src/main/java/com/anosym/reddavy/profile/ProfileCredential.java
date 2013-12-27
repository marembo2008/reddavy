/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile;

import com.anosym.utilities.IdGenerator;
import com.anosym.utilities.jbcrypt.BCrypt;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author marembo
 */
@Entity
public class ProfileCredential implements Serializable {

  private static final String PASSWORD_ERROR_MESSAGE = "Password does not match specified criterion: "
          + "at least one character(uppercase and lowercase), one digit and one special character "
          + "and  must be between 8 to 20 characters.";
  private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,20})";
  private static final String PASSWORD_NOT_SPECIFIED = "Password must be specified";
  private static final String USERNAME_NOT_SPECIFIED = "Username must be specified";
  private static final long serialVersionUID = 137438488930L;
  @Id
  private Long credentialId;
  @OneToOne
  @NotNull
  private Profile profile;
  @Column(length = 20, unique = true)
  @NotNull(message = USERNAME_NOT_SPECIFIED)
  private String username;
  @NotNull(message = PASSWORD_NOT_SPECIFIED)
  @Pattern(message = PASSWORD_ERROR_MESSAGE, regexp = PASSWORD_REGEX)
  private String password;

  public ProfileCredential() {
  }

  public ProfileCredential(Profile profile, String username, String password) {
    this.profile = profile;
    this.username = username;
    this.password = password;
  }

  @PrePersist
  void onPersist() {
    credentialId = IdGenerator.generateId();
    onPasswordReset();
  }

  public void onPasswordReset() {
    password = BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public Long getCredentialId() {
    return credentialId;
  }

  public void setCredentialId(Long credentialId) {
    this.credentialId = credentialId;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 17 * hash + (this.credentialId != null ? this.credentialId.hashCode() : 0);
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
    final ProfileCredential other = (ProfileCredential) obj;
    if (this.credentialId != other.credentialId && (this.credentialId == null || !this.credentialId.equals(other.credentialId))) {
      return false;
    }
    return true;
  }

}
