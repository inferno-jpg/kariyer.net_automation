package assertion;

import io.restassured.response.Response;
import org.testng.Assert;

public class GeneralAssertion {

    public void GeneralAssertion(Response response, String ReturnCode, String Message) {
        Assert.assertEquals(response.jsonPath().getString("statusCode"), ReturnCode, "Wrong Return Code Returned");
        Assert.assertEquals(response.jsonPath().getString("status").toUpperCase(), Message.toUpperCase(), "Wrong Message Returned");
    }

    public void PathAssertion(Response response, String path, Object parameter) {
        Assert.assertEquals(response.jsonPath().getString(path), parameter, "Wrong parameters");
    }

    public void NotNullAssertion(Response response, String path) {
        Assert.assertNotNull(response.jsonPath().get(path));
    }
    public void NotNullAssertion(Response response) {
        Assert.assertNotNull(response);
    }
    public void StatusCodeAssertion(Response response, String StatusCode){
        Assert.assertEquals(response.statusCode(),StatusCode);
    }

    public void NullAssertion(Response response, String path) {
        Assert.assertNull(response.jsonPath().get(path));
    }

}