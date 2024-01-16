package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PutBookingTest extends TestBase {
    static String token;

    @Test
    public void updateCurrentBooking() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName("David");
        bookingPojo.setLastName("Patel");
        bookingPojo.setTotalPrice(872);
        bookingPojo.setDepositPaid(false);
        List<String> bookingdates = new ArrayList<>();
        bookingdates.add("2023-06-02");
        bookingdates.add("2023-07-09");
        bookingPojo.setAdditionalneeds("Free Dairy Products only");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .pathParam("id", 10)
                .body(bookingPojo)
                .when().put("https://restful-booker.herokuapp.com/booking/{id}");
        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
