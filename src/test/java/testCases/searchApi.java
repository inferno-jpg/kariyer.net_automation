package testCases;

import assertion.GeneralAssertion;
import controllers.KariyerApiController;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.TestBaseClass;
import java.util.HashMap;


public class searchApi extends TestBaseClass {
    String requestBody;
    GeneralAssertion generalAssertion = new GeneralAssertion();
    KariyerApiController kariyerApiController = new KariyerApiController();

    @Test(priority = 1)
    public void TestCase_Kariyernet_Serach_Api_Success() {

        // Search api
        HashMap<String, String> searchApiHeader = new HashMap<>();
        searchApiHeader.put("Content-Type", "application/json");

        HashMap<String, Object> searchApiRequest = new HashMap<>();
        searchApiRequest.put("memberId",  Integer.parseInt(config.getProperty("memberId")));
        searchApiRequest.put("currentPage",  Integer.parseInt(config.getProperty("currentPage")));
        searchApiRequest.put("size",  Integer.parseInt(config.getProperty("size")));
        searchApiRequest.put("keyword", config.getProperty("keyword"));
        searchApiRequest.put("dontShowAppliedJobs", Boolean.parseBoolean(config.getProperty("dontShowAppliedJobs")));

        Response searchApiResponse = kariyerApiController.Post("search",searchApiRequest, searchApiHeader);

        System.out.print(searchApiResponse.prettyPrint());
        generalAssertion.GeneralAssertion(searchApiResponse, "Success", "Success");
        generalAssertion.NotNullAssertion(searchApiResponse,"data.jobs");

        System.out.print("\ncase is done");

    }
}