package com.restful.booker.crudtest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HealthCheckPingTest {
    @Test
    public void healthCheck(){
        Response response = given().log().all()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .get("https://restful-booker.herokuapp.com/ping");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
