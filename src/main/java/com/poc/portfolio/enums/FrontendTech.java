package com.poc.portfolio.enums;

public enum FrontendTech {
  HTML("HTML"), CSS("CSS"), REACT("ReactJS"), JS("JavaScript"), TYPESCRIPT("TypeScript"), ANGULAR("AngularJS");

  private final String value;

  FrontendTech(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
