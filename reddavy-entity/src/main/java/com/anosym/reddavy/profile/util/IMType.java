/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.util;

import com.anosym.utilities.Utility;

/**
 *
 * @author marembo
 */
public enum IMType {

  WHATSAPP,
  GOOGLE_HANGOUT,
  YAHOO,
  FACEBOOK,
  VIBER,
  LINKEDIN,
  TWITTER,
  SKYPE,
  WINDOWS_LIVE,
  JABBER;

  @Override
  public String toString() {
    String ss = name().replaceAll("_", " ").toLowerCase();
    return Utility.capitalize(ss);
  }

}
