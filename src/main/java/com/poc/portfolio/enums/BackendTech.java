package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum BackendTech {
  JAVA("JAVA 17+", ExperienceLevel.PROFESSIONAL.name()), NODE("Node JS",
      ExperienceLevel.INTERMEDIATE.name()), EXPRESS("Express JS", ExperienceLevel.INTERMEDIATE.name()), SPRING(
          "Spring",
          ExperienceLevel.PROFESSIONAL.name()), HELIDON("Helidon", ExperienceLevel.PROFESSIONAL.name());

  private final String technology;
  private final String experienceLevel;

  BackendTech(String technology, String experienceLevel) {
    this.technology = technology;
    this.experienceLevel = experienceLevel;
  }

}
