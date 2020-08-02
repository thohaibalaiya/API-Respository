package studentApitest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiVerifications.ApiVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import apiconfigs.APIPath;

public class GetApiTests extends BaseTest {
	@Test
	public void getAPITest() {
		//RestAssured.given().when().get(APIPath.apipath.GET_LIST_OF_USERS).then().log().all().statusCode(200);
	test.log(LogStatus.INFO, "My test is starting.....");
		Response res = RestAssured.given().when().get(APIPath.apipath.GET_LIST_OF_USERS);
		ApiVerification.responseCodeValidation(res, 200);
		ApiVerification.responseKeyValidationfromArray(res, "title");
		ApiVerification.responseTimeValidation(res);
		
		
	//System.out.println(res.getStatusCode());
	//System.out.println(res.getBody().asString());
	//System.out.println(res.getTime());
	
	//test.log(LogStatus.INFO, "My body is" + res.getBody().asString());
	//test.log(LogStatus.INFO, "My status code is" + res.getStatusCode());
	//test.log(LogStatus.INFO, "Respose time is" +res.getTime());
	//JSONArray array = new JSONArray(res.getBody().asString());
	/*for(int i=0; i<array.length(); i++) {
		//System.out.println(array.get(i));
		
		JSONObject obj = array.getJSONObject(i);
		//System.out.println(obj.get("title"));
		test.log(LogStatus.INFO, "Validated values are" +obj.get("title"));
		
	}*/
	test.log(LogStatus.PASS, "My test is pass and ended.....");
	}

}
