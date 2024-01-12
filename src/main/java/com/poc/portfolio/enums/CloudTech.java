package com.poc.portfolio.enums;

public enum CloudTech {
  AWS("AWS"), GCP("GCP");

  private final String value;

  CloudTech(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
