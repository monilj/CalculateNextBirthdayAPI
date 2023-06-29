package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {
    Response response=null;
    @Given("^API endpoints to calculate time left for next birthday$")
    public void apiEndpointsToCalculateTimeLeftForNextBirthday() throws IOException {
        RestAssured.baseURI = getBaseUri();
    }

    @When("^User Hit http get request provide query parameters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userHitHttpGetRequestProvideQueryParametersAnd(String arg0, String arg1) throws Throwable {
        response= given().
                queryParam("dateofbirth",arg0).
                queryParam("unit",arg1).
                when().
                get("/Prod/next-birthday");

    }

    @Then("^API response JSON must contains \"([^\"]*)\" with \"([^\"]*)\" left$")
    public void apiResponseJSONMustContainsWithLeft(String arg0, String arg1) throws Throwable {
        response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("message", equalTo(arg0+" "+arg1+" left"));

    }
    public String getBaseUri() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\Data Backup 2022\\IntellijProjects\\CalcalateBirthday\\src\\test\\resources\\env.properties");
        properties.load(fileInputStream);
        String baseUri =properties.getProperty("amazonApiHost");
        return baseUri;
    }
}
