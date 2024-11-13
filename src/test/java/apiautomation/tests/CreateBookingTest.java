package apiautomation.tests;

import apiautomation.base.ApiManager;
import apiautomation.pojos.BookingDatesModel;
import apiautomation.pojos.BookingRequestModel;
import apiautomation.pojos.BookingResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateBookingTest extends ApiManager {

    @Test
    public void createBooking() {
        BookingDatesModel bookingDatesModel = new BookingDatesModel("2026-01-01", "2026-03-03");
        BookingRequestModel requestBody = new BookingRequestModel("Yeni", "Rezervasyon", 224, false, bookingDatesModel, "one room");

        BookingResponseModel bookingResponseModel = sendBookingRequest(requestBody);

        Assertions.assertEquals("Yeni", bookingResponseModel.getBooking().getFirstname());
        Assertions.assertEquals(224, bookingResponseModel.getBooking().getTotalprice());
    }
}
