package com.poc.portfolio.img.project;

import com.poc.portfolio.img.ImgTagAttributes;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class ProjectImgTag extends ImgTagAttributes {
  private String projectName;
  private String onGithubClickAction;
  private String onLiveDemoClickAction;
}
