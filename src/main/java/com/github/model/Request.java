package com.github.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonRootName(value = "request")
@JacksonXmlRootElement(localName = "request")
@ApiModel(value = "request", description = "Request object", discriminator = "Request object")
public final class Request {

  @ApiModelProperty(notes = "This flag represents if the query UPDATE/DELETE will run without where or not", required = true)
  @JacksonXmlProperty
  private String message;

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
