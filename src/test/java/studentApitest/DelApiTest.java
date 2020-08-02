package studentApitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiVerifications.ApiVerification;
import apiconfigs.APIPath;
import apiconfigs.HeaderConfigs;
import appbuilders.PostApibuilder;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DelApiTest extends BaseTest{
	@BeforeMethod
	public void BeforeDelTest() {
		HeaderConfigs header = new HeaderConfigs();
		PostApibuilder builder = new PostApibuilder();
		test.log(LogStatus.INFO,"My test is starting........");
		Response res = RestAssured.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody("93", "thohai", "harman")).post(APIPath.apipath.CREATE_USER);
		System.out.println("Response is "+ res.getBody().asString());
		}
	@Test
	public void DelTest() {
		Response res1 = RestAssured.given().when().delete(APIPath.apipath.DELETE_USER);
		ApiVerification.responseCodeValidation(res1, 200);
		System.out.println("Response code is" +res1.getBody().asString());
		
	}
}