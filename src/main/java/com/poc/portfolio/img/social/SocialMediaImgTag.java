package com.poc.portfolio.img.social;

import com.poc.portfolio.img.ImgTagAttributes;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class SocialMediaImgTag extends ImgTagAttributes {
  private String onClickAction;
}
