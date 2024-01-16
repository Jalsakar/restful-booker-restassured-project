package com.restful.booker.crudtest;

import com.restful.booker.model.AuthPojo;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthTest {

    @Test
    public void verifyUserCanLoginSuccessfully(){

        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");

        Response response = given().log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type","application/json")
                .when()
                .body(authPojo)
                .post("/auth");
        response.then().log().all().statusCode(200);
        response.prettyPrint();
        String token = response.jsonPath().getString("token");
        System.out.println("Received Token is : " +token);
    }
}
