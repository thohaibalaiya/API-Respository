package studentApitest;

import org.testng.annotations.Test;

import apiconfigs.APIPath;
import apiconfigs.HeaderConfigs;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PostAPIPojo;

public class SerTest extends BaseTest{
	
	@Test
	public void Sertest1() {
		HeaderConfigs head = new HeaderConfigs();
		PostAPIPojo pojo = new PostAPIPojo(47, "sertest", "thohai");
		
		Response res = RestAssured.given().when().headers(head.defaultHeaders()).body(pojo).post(APIPath.apipath.CREATE_USER);
		System.out.println(res.getBody().asString());
		
		System.out.println(pojo.getAuthor());
		System.out.println(pojo.getTitle());
		System.out.println(pojo.getId());
	}
	

}
