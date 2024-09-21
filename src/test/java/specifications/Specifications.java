package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.TestBaseClass;

public class Specifications extends TestBaseClass {

    public RequestSpecification searchApiRequestSpec() {

        return new RequestSpecBuilder().
                setBaseUri(baseURL.getProperty("apiurl")).
                log(LogDetail.ALL).build().config((RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 20000))));
    }

    public ResponseSpecification searchApiResponseSpec() {

        return new ResponseSpecBuilder().
                build();
    }
}