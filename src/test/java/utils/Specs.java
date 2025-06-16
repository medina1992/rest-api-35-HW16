package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specs {

    public static RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setContentType("application/json")
            .addHeader("x-api-key", "reqres-free-v1")
            .log(io.restassured.filter.log.LogDetail.ALL)
            .build();

    public static ResponseSpecification respSpec201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(io.restassured.filter.log.LogDetail.ALL)
            .build();

    public static ResponseSpecification respSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(io.restassured.filter.log.LogDetail.ALL)
            .build();

    public static ResponseSpecification respSpec404 = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(io.restassured.filter.log.LogDetail.ALL)
            .build();
}
