package com.github.constants;

public enum LogAttribute {
  SPRING_FRAMEWORK("org.springframework.web");
  private String packageName;

  LogAttribute(String packageName) {
    this.packageName = packageName;
  }

  public String getPackageName() {
    return packageName;
  }

}

