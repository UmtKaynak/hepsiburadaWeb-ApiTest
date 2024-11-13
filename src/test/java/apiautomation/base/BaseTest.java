package apiautomation.base;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {
   public static RequestSpecification spec;

    /**
     * Spec is used for the pointed URl and set filter type
     */


    @BeforeAll
    public static void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilter(new io.restassured.filter.log.ResponseLoggingFilter(LogDetail.ALL))
                .build();
    }

}
