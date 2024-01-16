package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {
    static String token;

    @Test
    public void verifyBookingCreatedSuccessfully() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName("Prita");
        bookingPojo.setLastName("Patel");
        bookingPojo.setTotalPrice(175);
        bookingPojo.setDepositPaid(true);
        List<String> bookingdates = new ArrayList<>();
        bookingdates.add("2023-07-10");
        bookingdates.add("2023-08-24");
        bookingPojo.setAdditionalneeds("Vegetarian");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .when()
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
