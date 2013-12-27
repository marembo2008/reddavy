/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile;

import com.anosym.reddavy.profile.Profile;
import com.anosym.reddavy.profile.contact.PhoneBook;
import com.anosym.reddavy.profile.security.AccessLevel;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marembo
 */
@Entity
@Table(uniqueConstraints = {
  @UniqueConstraint(columnNames = {"phoneBook_phoneBookId", "profile_profileId"})})
@NamedQueries({
  @NamedQuery(name = "ProfilePhoneBook.find_profile_phone_books_by_profile",
          query = "SELECT ppb FROM ProfilePhoneBook ppb WHERE ppb.profile.profileId = :profileId"),
  @NamedQuery(name = "ProfilePhoneBook.find_profiles_by_phone_book",
          query = "SELECT ppb.profile FROM ProfilePhoneBook ppb WHERE ppb.phoneBook.phoneBookId = :phoneBookId"),
  @NamedQuery(name = "ProfilePhoneBook.find_phone_books_by_profile",
          query = "SELECT ppb.phoneBook FROM ProfilePhoneBook ppb WHERE ppb.profile.profileId = :profileId")})
public class ProfilePhoneBook implements Serializable {

  private static final long serialVersionUID = 4784948902421L;
  @Id
  private Long profilePhoneBookId;
  @ManyToOne
  private PhoneBook phoneBook;
  @ManyToOne
  private Profile profile;
  /**
   * The access role for attached to this profile for this phonebook.
   */
  private AccessLevel accessLevel;

  public Long getProfilePhoneBookId() {
    return profilePhoneBookId;
  }

  public void setProfilePhoneBookId(Long profilePhoneBookId) {
    this.profilePhoneBookId = profilePhoneBookId;
  }

  public PhoneBook getPhoneBook() {
    return phoneBook;
  }

  public void setPhoneBook(PhoneBook phoneBook) {
    this.phoneBook = phoneBook;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public AccessLevel getAccessLevel() {
    return accessLevel;
  }

  public void setAccessLevel(AccessLevel accessLevel) {
    this.accessLevel = accessLevel;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + (this.profilePhoneBookId != null ? this.profilePhoneBookId.hashCode() : 0);
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
    final ProfilePhoneBook other = (ProfilePhoneBook) obj;
    return this.profilePhoneBookId == other.profilePhoneBookId || (this.profilePhoneBookId != null && this.profilePhoneBookId.equals(other.profilePhoneBookId));
  }

}
