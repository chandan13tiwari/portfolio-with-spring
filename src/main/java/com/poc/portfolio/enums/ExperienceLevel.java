package com.poc.portfolio.enums;

public enum ExperienceLevel {
  BEGINNER("Beginner"), INTERMEDIATE("Intermediate"), EXPERIENCED("Experienced");

  private final String value;

  ExperienceLevel(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
