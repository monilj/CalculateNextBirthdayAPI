package calculatebirthday;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CalculateNextBirthday  extends BaseClassForAWSApi{
    @Test
    public void timeToLeftForNextBirthday() throws IOException {
        RestAssured.baseURI = getBaseUri();
        given().
                queryParam("dateofbirth","1990-02-16").
                queryParam("unit","week").
                when().
                get("/Prod/next-birthday").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("message", equalTo("33 weeks left"));


    }
}
