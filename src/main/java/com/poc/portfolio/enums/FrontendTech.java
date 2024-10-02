package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum FrontendTech {
  HTML("HTML", ExperienceLevel.PROFESSIONAL.name()), CSS("CSS", ExperienceLevel.PROFESSIONAL.name()), REACT("ReactJS",
      ExperienceLevel.EXPERIENCED.name()), JS("JavaScript", ExperienceLevel.PROFESSIONAL.name()), TYPESCRIPT(
          "TypeScript", ExperienceLevel.PROFESSIONAL.name()), ANGULAR("AngularJS",
              ExperienceLevel.EXPERIENCED.name()), OJET("Oracle Javascript Extension",
                  ExperienceLevel.PROFESSIONAL.name());

  private final String technology;
  private final String experienceLevel;

  FrontendTech(String technology, String experienceLevel) {
    this.technology = technology;
    this.experienceLevel = experienceLevel;
  }

}
