package com.bdd.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Products {

  public RequestSpecification httpRequest;
  public Response response;

  @Given("the API is running")
  public void the_api_is_running() {
    RestAssured.baseURI = "https://fakestoreapi.com/";
  }

  @When("I send a GET request to {string}")
  public void i_send_a_get_request_to(String path) {
    httpRequest = RestAssured.given();
    response = httpRequest.get(path);
  }

  @Then("the response status code should be {int}")
  public void the_response_status_code_should_be(int expectedCode) {
    assertEquals(expectedCode, response.getStatusCode());
  }

  @And("the response should contain a list of products")
  public void the_response_should_contain_a_list_of_products() {
    assertNotNull(response.getBody());
  }

  @And("the response should contain the rate as {string}")
  public void the_response_should_contain_the_rate_as(String rate) {
    JsonPath jsonPath = response.jsonPath();
    Object actualRate = jsonPath.getJsonObject("rating.rate");
    assertNotNull("Rating object is null", actualRate);
    assertEquals(rate, actualRate.toString());
  }
}