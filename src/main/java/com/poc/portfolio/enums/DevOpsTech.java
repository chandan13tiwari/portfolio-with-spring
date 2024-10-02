package com.poc.portfolio.enums;

import lombok.Getter;

@Getter
public enum DevOpsTech {
  DOCKER("Docker", ExperienceLevel.PROFESSIONAL.name()), JENKINS("Jenkins",
      ExperienceLevel.PROFESSIONAL.name()), KUBERNETES("Kubernetes", ExperienceLevel.PROFESSIONAL
          .name()), ELASTICSEARCH("ElasticSearch", ExperienceLevel.EXPERIENCED.name()), LIQUIBASE("Liquibase",
              ExperienceLevel.PROFESSIONAL.name()), SPLUNK("Splunk", ExperienceLevel.EXPERIENCED.name());

  private final String technology;
  private final String experienceLevel;

  DevOpsTech(String technology, String experienceLevel) {
    this.technology = technology;
    this.experienceLevel = experienceLevel;
  }

}
