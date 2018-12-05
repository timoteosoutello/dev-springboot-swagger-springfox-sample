package com.github.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "response", description = "Response object", discriminator = "Response object", reference = "Response object")
public final class Response {
  @JacksonXmlProperty
  @JsonInclude(Include.NON_NULL)
  private String message;
  @JacksonXmlProperty
  @JsonInclude(Include.NON_NULL)
  private String detailMessage;
  @JsonIgnore
  private HttpStatus status;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getDetailMessage() {
    return detailMessage;
  }

  public void setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
