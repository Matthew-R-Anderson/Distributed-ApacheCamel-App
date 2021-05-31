/*
 * Sales Service
 * REST service for managing customer sales.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Summary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-12T13:31:51.692303+12:00[Pacific/Auckland]")
public class Summary {
  public static final String SERIALIZED_NAME_NUMBER_OF_SALES = "numberOfSales";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_SALES)
  private Integer numberOfSales;

  public static final String SERIALIZED_NAME_TOTAL_PAYMENT = "totalPayment";
  @SerializedName(SERIALIZED_NAME_TOTAL_PAYMENT)
  private Double totalPayment;

  public static final String SERIALIZED_NAME_GROUP = "group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private String group;


  public Summary numberOfSales(Integer numberOfSales) {
    
    this.numberOfSales = numberOfSales;
    return this;
  }

   /**
   * Get numberOfSales
   * @return numberOfSales
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getNumberOfSales() {
    return numberOfSales;
  }


  public void setNumberOfSales(Integer numberOfSales) {
    this.numberOfSales = numberOfSales;
  }


  public Summary totalPayment(Double totalPayment) {
    
    this.totalPayment = totalPayment;
    return this;
  }

   /**
   * Get totalPayment
   * @return totalPayment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Double getTotalPayment() {
    return totalPayment;
  }


  public void setTotalPayment(Double totalPayment) {
    this.totalPayment = totalPayment;
  }


  public Summary group(String group) {
    
    this.group = group;
    return this;
  }

   /**
   * Get group
   * @return group
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGroup() {
    return group;
  }


  public void setGroup(String group) {
    this.group = group;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(this.numberOfSales, summary.numberOfSales) &&
        Objects.equals(this.totalPayment, summary.totalPayment) &&
        Objects.equals(this.group, summary.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfSales, totalPayment, group);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    sb.append("    numberOfSales: ").append(toIndentedString(numberOfSales)).append("\n");
    sb.append("    totalPayment: ").append(toIndentedString(totalPayment)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

