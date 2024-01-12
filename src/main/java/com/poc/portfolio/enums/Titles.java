package com.poc.portfolio.enums;

public enum Titles {
  SOFTWARE_DEVELOPMENT_ENGINEER("Software Development Engineer"), CONTENT_CREATOR("Content Creator"), MUSIC_PRODUCER(
      "Music Producer");

  private final String value;

  Titles(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
