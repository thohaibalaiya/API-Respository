package studentApitest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiVerifications.ApiVerification;
import apiconfigs.APIPath;
import apiconfigs.HeaderConfigs;
import appbuilders.PostApibuilder;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtils;

public class PostApiTest extends BaseTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void validPostApiTest() {
		HeaderConfigs header = new HeaderConfigs();
		PostApibuilder builder = new PostApibuilder();
		JavaUtils util = new JavaUtils();
		
		/*To generate random integer value
		Random random = new Random();
		int randomnumber = random.nextInt();
		String id =Integer.toString(randomnumber);
		
		//To generate string values
		String randomString = RandomStringUtils.randomAlphabetic(5);*/
		//System.out.println("Random int value" +util.randomnumber()+"Random string is"+util.randomString());
		
		test.log(LogStatus.INFO, "My test is starting....");
		//Response res = RestAssured.given().when().headers(header.defaultHeaders()).
		//body(builder.postRequestBody(util.randomnumber(), util.randomString(), util.randomString())).post(APIPath.apipath.CREATE_USER);
		Response res = RestAssured.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody("98", "thohu", "harmu")).post(APIPath.apipath.CREATE_USER);
		
		ApiVerification.responseKeyValidationfromJsonObject(res, "title");
		ApiVerification.responseCodeValidation(res, 201);
		ApiVerification.responseTimeValidation(res);
		//System.out.println("Response is" +res.getBody().asString());
		//System.out.println("Response code is" +res.getStatusCode());
		
		test.log(LogStatus.INFO, "My test is end and pass....");
		
	}
	

}
