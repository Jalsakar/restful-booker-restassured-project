package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBookingTest extends TestBase {

    static String firstname = "Susan" + TestUtils.getRandomValue();
    static String lastname = "Smith" + TestUtils.getRandomValue();
    static int totalPrice = 500;
    static boolean depositPaid = true;
    static String additionalNeeds = "Vegen food only";
    static String token;

    @Test
    public void getAllBookingIDs() {

        BookingPojo bookingPojo = new BookingPojo();
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .when().get("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void getBooking() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(firstname);
        bookingPojo.setLastName(lastname);
        bookingPojo.setTotalPrice(totalPrice);
        bookingPojo.setDepositPaid(depositPaid);
        List<String> bookingdates = new ArrayList<>();
        bookingdates.add("2018-01-01");
        bookingdates.add("2019-01-01");
        bookingPojo.setAdditionalneeds(additionalNeeds);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("id", 1532)
                .body(bookingPojo)
                .when().get("https://restful-booker.herokuapp.com/booking/{id}");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void getBookingIdsWithFirstName() {

        BookingPojo bookingPojo = new BookingPojo();

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookingPojo)
                .param("firstname", firstname)
                .when().get("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
    }
}
