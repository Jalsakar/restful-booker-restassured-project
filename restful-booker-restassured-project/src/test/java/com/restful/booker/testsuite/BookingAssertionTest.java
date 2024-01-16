package com.restful.booker.testsuite;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookingAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/6")
                .then().statusCode(200);
    }

    // Verify fristname = Mary
    @Test
    public void test01(){
        System.out.println("The First name value is : " + response.extract().path("firstname"));
    }

    // Verify checkin is on 2016-11-06
    @Test
    public void test002(){
        response.body("bookingdates.checkin", equalTo("2016-11-06"));
    }

    //Verify total price is greater than 100
    @Test
    public void test003()
    {
        response.body("totalprice", greaterThan(100));
    }

    //Verify that the lastname is "Ericsson"
    @Test
    public void test004(){
        response.body("lastname", equalTo("Ericsson"));
    }

    // Verify checkout is on 2018-04-21
    @Test
    public void test005(){
        response.body("bookingdates.checkout", equalTo("2021-09-21"));
    }

}
