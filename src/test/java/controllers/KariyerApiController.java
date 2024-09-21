package controllers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifications.Specifications;
import utilities.TestBaseClass;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class KariyerApiController extends TestBaseClass {

    public Response Post(String path, Object payload, HashMap header) {

        RequestSpecification requestSpecification = new Specifications().searchApiRequestSpec();
        ResponseSpecification responseSpecification = new Specifications().searchApiResponseSpec();
        Response response;
        response = given(requestSpecification).

                headers(header).
                when().
                body(payload).
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        return response;
    }

    public Response Post(String path, HashMap header) {

        RequestSpecification requestSpecification = new Specifications().searchApiRequestSpec();
        ResponseSpecification responseSpecification = new Specifications().searchApiResponseSpec();
        Response response;
        response = given(requestSpecification).
                headers(header).
                when().
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        return response;
    }

}