package apiautomation.tests;

import apiautomation.base.ApiManager;
import apiautomation.pojos.BookingDatesModel;
import apiautomation.pojos.BookingRequestModel;
import apiautomation.pojos.BookingResponseModel;
import apiautomation.pojos.UpdatedBookingResponseModel;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends ApiManager {

    @Test
    public void updateBooking() {
        BookingResponseModel oldResponse = makeBookingWithOutEnteringInformation();

        BookingDatesModel bookingDatesModel = new BookingDatesModel("2026-01-01", "2026-03-03");
        BookingRequestModel updateRequestModel = new BookingRequestModel("New", "Booking", 555, false, bookingDatesModel, "two room");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + getToken().getTokenValue())
                .when()
                .body(updateRequestModel)
                .put("/booking/" + oldResponse.getBookingid());
        response
                .then()
                .statusCode(200);

        UpdatedBookingResponseModel updatedResponse = response.as(UpdatedBookingResponseModel.class);
        Assertions.assertEquals("Otomasyon", oldResponse.getBooking().getFirstname());
        Assertions.assertEquals("New", updatedResponse.getFirstname());
    }

    @Test
    public void partialUpdateBooking() {
        JsonObject newInformation = new JsonObject();
        newInformation.add("firstname", "UpdatedFirstName");
        newInformation.add("lastname", "UpdatedLastName");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + getToken().getTokenValue())
                .when()
                .body(newInformation.toString())
                .patch("/booking/" + createBookingID());

        Assertions.assertEquals("UpdatedFirstName", response.jsonPath().getJsonObject("firstname"));
        Assertions.assertEquals("UpdatedLastName", response.jsonPath().getJsonObject("lastname"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("depositpaid"));
    }
}
