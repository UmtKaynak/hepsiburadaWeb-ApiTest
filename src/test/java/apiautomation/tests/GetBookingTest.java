package apiautomation.tests;

import apiautomation.base.ApiManager;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends ApiManager {


    @Test
    public void getAllBooking() {
        given(spec)
                .when().get("/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void GetSpecificBooking() {
        Response response = given(spec)
                .when()
                .get("/booking/" + createBookingID());
        Assertions.assertEquals(200, response.statusCode(), "Request is failed");
    }
}
