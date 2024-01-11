package com.poc.portfolio.img.client;

import com.poc.portfolio.img.ImgTagAttributes;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class ClientImgTag extends ImgTagAttributes {
  private boolean draggable;
  private String clientName;
  private String designation;
}
