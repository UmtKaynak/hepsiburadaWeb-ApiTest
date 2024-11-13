package apiautomation.base;

import apiautomation.pojos.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiManager extends BaseTest {

    /**
     * This class is created to reduce code repetition.
     * Major requests are located here.
     *
     */

    protected BookingResponseModel sendBookingRequest(BookingRequestModel bookingRequestModel) {
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(bookingRequestModel)
                .post("/booking");
        response.then().statusCode(200);
        return response.as(BookingResponseModel.class);
    }

    protected BookingResponseModel makeBookingWithOutEnteringInformation() {
        BookingDatesModel bookingDatesModel = new BookingDatesModel("2025-01-01", "2025-03-03");
        BookingRequestModel bookingRequestModel = new BookingRequestModel("Otomasyon", "Api", 655,
                true, bookingDatesModel, "Klima");
        return sendBookingRequest(bookingRequestModel);
    }


    protected int createBookingID() {
        BookingResponseModel newReservation = makeBookingWithOutEnteringInformation();
        return newReservation.getBookingid();
    }

    protected AuthResponseModel getToken() {
        AuthRequestModel authRequestModel = new AuthRequestModel("admin", "password123");
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(authRequestModel)
                .post("/auth");
        return response.as(AuthResponseModel.class);
    }
}
