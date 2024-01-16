package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {
    static String token;

    @Test
    public void updatePartiallyRecord() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName("Jenna");
        bookingPojo.setLastName("Smriti");
        bookingPojo.setAdditionalneeds("Lunch");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Cookie", "token=" + token)
                .pathParam("id", 10)
                .body(bookingPojo)
                .when().patch("https://restful-booker.herokuapp.com/booking/{id}");

        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
