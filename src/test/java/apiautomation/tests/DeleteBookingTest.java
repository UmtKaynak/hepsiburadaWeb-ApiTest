package apiautomation.tests;

import apiautomation.base.ApiManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends ApiManager {

    @Test
    public void deleteBooking() {
        int reservationID = createBookingID();
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + getToken().getTokenValue())
                .when()
                .delete("/booking/" + reservationID);
        Assertions.assertEquals(201, response.statusCode(), "Reservation is cannot deleted");

    }
}
