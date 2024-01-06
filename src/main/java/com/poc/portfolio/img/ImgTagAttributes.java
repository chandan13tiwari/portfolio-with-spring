package com.poc.portfolio.img;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class ImgTagAttributes {
    String assetUrl;
    String altName;
}
