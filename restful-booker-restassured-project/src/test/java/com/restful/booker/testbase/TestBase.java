package com.restful.booker.testbase;

import com.restful.booker.utils.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init(){
        propertyReader= PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = propertyReader.getProperty("basePath");
    }
}
