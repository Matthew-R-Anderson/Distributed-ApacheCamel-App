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
import domain.Customer;
import domain.SaleItem;
import domain.Totals;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sale
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-12T13:31:51.692303+12:00[Pacific/Auckland]")
public class Sale {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_SALE_DATE = "sale_date";
  @SerializedName(SERIALIZED_NAME_SALE_DATE)
  private String saleDate;

  public static final String SERIALIZED_NAME_CUSTOMER = "customer";
  @SerializedName(SERIALIZED_NAME_CUSTOMER)
  private Customer customer;

  public static final String SERIALIZED_NAME_REGISTER_SALE_PRODUCTS = "register_sale_products";
  @SerializedName(SERIALIZED_NAME_REGISTER_SALE_PRODUCTS)
  private List<SaleItem> registerSaleProducts = null;

  public static final String SERIALIZED_NAME_TOTALS = "totals";
  @SerializedName(SERIALIZED_NAME_TOTALS)
  private Totals totals;


  public Sale id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Sale saleDate(String saleDate) {
    
    this.saleDate = saleDate;
    return this;
  }

   /**
   * Get saleDate
   * @return saleDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSaleDate() {
    return saleDate;
  }


  public void setSaleDate(String saleDate) {
    this.saleDate = saleDate;
  }


  public Sale customer(Customer customer) {
    
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Customer getCustomer() {
    return customer;
  }


  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  public Sale registerSaleProducts(List<SaleItem> registerSaleProducts) {
    
    this.registerSaleProducts = registerSaleProducts;
    return this;
  }

  public Sale addRegisterSaleProductsItem(SaleItem registerSaleProductsItem) {
    if (this.registerSaleProducts == null) {
      this.registerSaleProducts = new ArrayList<>();
    }
    this.registerSaleProducts.add(registerSaleProductsItem);
    return this;
  }

   /**
   * Get registerSaleProducts
   * @return registerSaleProducts
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<SaleItem> getRegisterSaleProducts() {
    return registerSaleProducts;
  }


  public void setRegisterSaleProducts(List<SaleItem> registerSaleProducts) {
    this.registerSaleProducts = registerSaleProducts;
  }


  public Sale totals(Totals totals) {
    
    this.totals = totals;
    return this;
  }

   /**
   * Get totals
   * @return totals
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Totals getTotals() {
    return totals;
  }


  public void setTotals(Totals totals) {
    this.totals = totals;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(this.id, sale.id) &&
        Objects.equals(this.saleDate, sale.saleDate) &&
        Objects.equals(this.customer, sale.customer) &&
        Objects.equals(this.registerSaleProducts, sale.registerSaleProducts) &&
        Objects.equals(this.totals, sale.totals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, saleDate, customer, registerSaleProducts, totals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sale {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    saleDate: ").append(toIndentedString(saleDate)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    registerSaleProducts: ").append(toIndentedString(registerSaleProducts)).append("\n");
    sb.append("    totals: ").append(toIndentedString(totals)).append("\n");
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
