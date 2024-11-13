package apiautomation.tests;

import apiautomation.base.ApiManager;
import apiautomation.pojos.AuthRequestModel;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookingAuthTest extends ApiManager {

    @Test
    public void createToken() {
        AuthRequestModel authRequestModel=new AuthRequestModel("admin","password123");
        given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(authRequestModel)
                .post("/auth")
                .then()
                .statusCode(200);
    }
}
