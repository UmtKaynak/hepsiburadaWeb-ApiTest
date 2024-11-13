package apiautomation.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BookingAuthTest.class,
        GetBookingTest.class,
        CreateBookingTest.class,
        UpdateBookingTest.class,
        DeleteBookingTest.class
})
public class ApiTestSuite {
}