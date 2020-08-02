package DeserializingTest;

import org.testng.annotations.Test;

import DeserializingPojo.ListUsersPOJO;
import io.restassured.RestAssured;

public class DeTest {
	
	@Test
	public void DeTest1() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		ListUsersPOJO pojo = RestAssured.given().when().get().as(ListUsersPOJO.class);
		System.out.println(pojo.toString());
		System.out.println(pojo.getPage());
		
	}

}
