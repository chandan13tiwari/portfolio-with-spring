package com.poc.portfolio.img;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class ImgTagAttributes {
  private String assetUrl;
  private String altName;
}
