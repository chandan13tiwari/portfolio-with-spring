package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum CloudTech {
  AWS("AWS", ExperienceLevel.PROFESSIONAL.name()), GCP("GCP", ExperienceLevel.BEGINNER.name()), OCI("OCI",
      ExperienceLevel.EXPERIENCED.name());

  private final String technology;
  private final String experienceLevel;

  CloudTech(String technology, String experienceLevel) {
    this.technology = technology;
    this.experienceLevel = experienceLevel;
  }

}
