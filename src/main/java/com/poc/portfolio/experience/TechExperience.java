package com.poc.portfolio.experience;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechExperience {
  private String technology;
  private String expLevel;
}
