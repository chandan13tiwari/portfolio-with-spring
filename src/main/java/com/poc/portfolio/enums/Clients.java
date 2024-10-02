package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum Clients {
  ORACLE("Oracle"), MCQ("Macquarie"), AMEX("American Express"), EY("Ernst & Young LLP"), HSBC("HSBC"), CAPG(
      "Capgemini"), INFOSYS("Infosys");

  private final String value;

  Clients(String value) {
    this.value = value;
  }

}
