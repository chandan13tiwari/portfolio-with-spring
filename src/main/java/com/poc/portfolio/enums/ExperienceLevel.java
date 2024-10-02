package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum ExperienceLevel {
  BEGINNER("Beginner"), INTERMEDIATE("Intermediate"), EXPERIENCED("Experienced"), PROFESSIONAL("Professional");

  private final String value;

  ExperienceLevel(String value) {
    this.value = value;
  }

}
