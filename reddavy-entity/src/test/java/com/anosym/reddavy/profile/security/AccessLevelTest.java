/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class AccessLevelTest {

  public AccessLevelTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetAccessRules() {
    System.setProperty(AccessLevel.AccessLevelDefinition.ACCESS_LEVEL_DEFINITION_PATH, System.getProperty("user.home") + "/test");
    AccessLevel this_ = AccessLevel.LEVEL_1;
    List<AccessRule> expected = new ArrayList<AccessRule>(Arrays.asList(AccessRule.VIEW_PHONEBOOK, AccessRule.EDIT_PHONEBOOK));
    List<AccessRule> actual = this_.getAccessRules();
    Assert.assertEquals(expected, actual);
  }

}
