/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.reddavy.profile.security;

import com.anosym.vjax.VMarshaller;
import com.anosym.vjax.annotations.MapElement;
import com.anosym.vjax.xml.VDocument;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marembo
 */
public enum AccessLevel {

  LEVEL_1,
  LEVEL_2,
  LEVEL_3,
  LEVEL_4,
  LEVEL_5;
  private static AccessLevelDefinition accessLevelDefinition;

  public List<AccessRule> getAccessRules() {
    if (accessLevelDefinition == null) {
      loadAccessLevelDefinition();
    }
    return accessLevelDefinition.getAccessRules(this);
  }

  @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
  private void loadAccessLevelDefinition() {
    try {
      String path = System.getProperty(AccessLevelDefinition.ACCESS_LEVEL_DEFINITION_PATH, System.getProperty("user.home"));
      File document = new File(path, AccessLevelDefinition.ACCESS_LEVEL_DEFINITION_DOCUMENT);
      if (document.exists()) {
        VMarshaller<AccessLevelDefinition> vom = new VMarshaller<AccessLevelDefinition>();
        VDocument doc = VDocument.parseDocument(document);
        accessLevelDefinition = vom.unmarshall(doc);
      } else {
        if (!document.getParentFile().exists()) {
          document.getParentFile().mkdirs();
        }
        accessLevelDefinition = new AccessLevelDefinition();
        VMarshaller<AccessLevelDefinition> vom = new VMarshaller<AccessLevelDefinition>();
        VDocument doc = vom.marshallDocument(accessLevelDefinition);
        doc.setDocumentName(document);
        doc.writeDocument();
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  static class AccessLevelDefinition {

    final static String ACCESS_LEVEL_DEFINITION_PATH = "com.anosym.reddavy.access-level-path";
    final static String ACCESS_LEVEL_DEFINITION_DOCUMENT = "access-level.al";
    private Map<AccessLevel, List<AccessRule>> accessLevels;

    public AccessLevelDefinition() {
      accessLevels = new EnumMap<AccessLevel, List<AccessRule>>(AccessLevel.class);
      accessLevels.put(LEVEL_1, new ArrayList<AccessRule>(Arrays.asList(AccessRule.VIEW_PHONEBOOK)));
      accessLevels.put(LEVEL_2, new ArrayList<AccessRule>(Arrays.asList(AccessRule.VIEW_PHONEBOOK)));
      accessLevels.put(LEVEL_3, new ArrayList<AccessRule>(Arrays.asList(AccessRule.VIEW_PHONEBOOK)));
      accessLevels.put(LEVEL_4, new ArrayList<AccessRule>(Arrays.asList(AccessRule.VIEW_PHONEBOOK)));
      accessLevels.put(LEVEL_5, new ArrayList<AccessRule>(Arrays.asList(AccessRule.values())));
    }

    public void setAccessLevels(Map<AccessLevel, List<AccessRule>> accessLevels) {
      this.accessLevels = accessLevels;
    }

    @MapElement(entry = "accessDefinition", key = "accessLevel", value = "accessRules")
    public Map<AccessLevel, List<AccessRule>> getAccessLevels() {
      return accessLevels;
    }

    public List<AccessRule> getAccessRules(AccessLevel accessLevel) {
      return accessLevels.get(accessLevel);
    }

  }
}
