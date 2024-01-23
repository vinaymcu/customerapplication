package com.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.*;
import javax.annotation.Generated;

/**
 * CustomerReq model for Customer Request prccessing
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-19T17:20:09.696+05:30[Asia/Calcutta]")
public class CustomerReq {

  @JsonProperty("id")
  private String id;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("gender")
  private String gender;

  @JsonProperty("dob")
  private String dob;

  public List<CustomerOrders> getCustomerOrders() {
    return customerOrders;
  }

  public void setCustomerOrders(List<CustomerOrders> customerOrders) {
    this.customerOrders = customerOrders;
  }

  @JsonProperty("customer_orders")
  List<CustomerOrders> customerOrders;

  public CustomerAddress getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(CustomerAddress customerAddress) {
    this.customerAddress = customerAddress;
  }

  @JsonProperty("customer_address")
  CustomerAddress customerAddress;


/**
  public CustomerReq id(String id) {
    this.id = id;
    return this;
  }
*/
  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**public CustomerReq firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }*/

  /**
   * Get firstName
   * @return firstName
  */
  
  @Schema(name = "first_name", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
/**
  public CustomerReq lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
*/
  /**
   * Get lastName
   * @return lastName
  */
  
  @Schema(name = "last_name", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
/**
  public CustomerReq email(String email) {
    this.email = email;
    return this;
  }
*/
  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
/**
  public CustomerReq gender(String gender) {
    this.gender = gender;
    return this;
  }
*/
  /**
   * Get gender
   * @return gender
  */
  
  @Schema(name = "gender", required = false)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
/**
  public CustomerReq dob(String dob) {
    this.dob = dob;
    return this;
  }
*/
  /**
   * Get dob
   * @return dob
  */
  
  @Schema(name = "dob", required = false)
  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
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
    CustomerReq customerReq = (CustomerReq) o;
    return Objects.equals(this.id, customerReq.id) &&
        Objects.equals(this.firstName, customerReq.firstName) &&
        Objects.equals(this.lastName, customerReq.lastName) &&
        Objects.equals(this.email, customerReq.email) &&
        Objects.equals(this.gender, customerReq.gender) &&
        Objects.equals(this.dob, customerReq.dob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, gender, dob);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerReq {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
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

