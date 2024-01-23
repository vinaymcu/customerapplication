package com.customer.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;

/**
 * CustomerRes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-19T17:20:09.696+05:30[Asia/Calcutta]")
public class CustomerRes {



  @JsonProperty("payload")
  private Payload payload;
/**
  public CustomerRes userMessages(List<String> userMessages) {
    this.userMessages = userMessages;
    return this;
  }

  public CustomerRes addUserMessagesItem(String userMessagesItem) {
    if (this.userMessages == null) {
      this.userMessages = new ArrayList<>();
    }
    this.userMessages.add(userMessagesItem);
    return this;
  }
*/
  /**
   * Get userMessages
   * @return userMessages
  */

  @JsonProperty("userMessages")
  @Valid
  private List<String> userMessages = null;

  @JsonProperty("serviceErrors")
  @Valid
  private List<String> serviceErrors = null;
  
  @Schema(name = "userMessages", example = "[\"str1\",\"str2\",\"str3\"]", required = false)
  public List<String> getUserMessages() {
    return userMessages;
  }

  public void setUserMessages(List<String> userMessages) {
    this.userMessages = userMessages;
  }
/**
  public CustomerRes serviceErrors(List<String> serviceErrors) {
    this.serviceErrors = serviceErrors;
    return this;
  }

  public CustomerRes addServiceErrorsItem(String serviceErrorsItem) {
    if (this.serviceErrors == null) {
      this.serviceErrors = new ArrayList<>();
    }
    this.serviceErrors.add(serviceErrorsItem);
    return this;
  }
*/
  /**
   * Get serviceErrors
   * @return serviceErrors
  */
  
  @Schema(name = "serviceErrors", example = "[\"str1\",\"str2\",\"str3\"]", required = false)
  public List<String> getServiceErrors() {
    return serviceErrors;
  }

  public void setServiceErrors(List<String> serviceErrors) {
    this.serviceErrors = serviceErrors;
  }

  public CustomerRes payload(Payload payload) {
    this.payload = payload;
    return this;
  }

  /**
   * Get payload
   * @return payload
  */
  /**
  @Valid 
  @Schema(name = "payload", required = false)
  public Payload getPayload() {
    return payload;
  }
*/
  public void setPayload(Payload payload) {
    this.payload = payload;
  }
/**
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRes customerRes = (CustomerRes) o;
    return Objects.equals(this.userMessages, customerRes.userMessages) &&
        Objects.equals(this.serviceErrors, customerRes.serviceErrors) &&
        Objects.equals(this.payload, customerRes.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userMessages, serviceErrors, payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRes {\n");
    sb.append("    userMessages: ").append(toIndentedString(userMessages)).append("\n");
    sb.append("    serviceErrors: ").append(toIndentedString(serviceErrors)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("}");
    return sb.toString();
  }
*/
  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  /**
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
   */
}

