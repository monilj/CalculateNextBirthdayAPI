package stepdefinitions;

import calculatebirthday.BaseClassForAWSApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.core.IsEqual.equalTo;

public class StepToCalculateNextBirthday extends BaseClassForAWSApi {
    RestAssured requestSpecifications=null;
    @Given("API endpoints to calculate time left for next birthday")
    public void apiEndpointsToCalculateTimeLeftForNextBirthday() throws IOException {
        RestAssured.baseURI = getBaseUri();
    }
    @When("User Hit http get request provide query parameters {string} and {string}")
    public void userHitHttpGetRequestProvideQueryParametersAnd(String arg0, String arg1) {
            requestSpecifications = (RestAssured) given().
                    queryParam("dateofbirth", arg0).
                    queryParam("unit", arg1);
        }
    @Then("API response JSON must contains {string} with {string} left")
    public void apiResponseJSONMustContainsWithLeft(String arg0, String arg1) {
        requestSpecifications.when().
                get("/Prod/next-birthday").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("message", equalTo("33 weeks left"));
    }
}
