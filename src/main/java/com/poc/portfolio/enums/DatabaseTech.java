package com.poc.portfolio.enums;

public enum DatabaseTech {
  POSTGRESQL("PostgreSQL"), ORACLEDB("OracleDB"), MYSQL("MySQL");

  private final String value;

  DatabaseTech(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
