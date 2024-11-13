package apiautomation.pojos;

public class BookingResponseModel {

    private int bookingid;
    private BookingRequestModel booking;

    public BookingResponseModel(int bookingid, BookingRequestModel booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseModel() {
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingRequestModel getBooking() {
        return booking;
    }

    public void setBooking(BookingRequestModel booking) {
        this.booking = booking;
    }
}
