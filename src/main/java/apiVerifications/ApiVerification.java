package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;


public class ApiVerification extends ExtentReportListner {
	public static void responseCodeValidation(Response res, int statusCode) {
		try {
			Assert.assertEquals(statusCode, res.getStatusCode());
			test.log(LogStatus.PASS, "Successfully validated status code is :: " + res.getStatusCode());
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL, 
					" Wrong Status code is :: "  + res.getStatusCode());
		}catch(Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

public static void responseKeyValidationfromArray(Response res,String key) {
	try{
		JSONArray array = new JSONArray(res.getBody().asString());
		for(int i=0; i<array.length(); i++) {
		JSONObject obj = array.getJSONObject(i);
		test.log(LogStatus.PASS, "Validated values are" +obj.get(key));
		}
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
}
	public static void responseKeyValidationfromJsonObject(Response res, String key) {
		try {
			JSONObject json = new JSONObject(res.getBody().asString());
			if(json.has(key)&& json.get(key)!=null) {
				test.log(LogStatus.PASS, "Successfully validated values of " +key+ " it is " +json.get(key));
			}else {
				test.log(LogStatus.FAIL, "Key is not available");
			}
		}	catch(Exception e) {
					test.log(LogStatus.FAIL, e.fillInStackTrace());
			
		}
	}
	

public static void responseTimeValidation(Response res) {
	try {
		long time=res.time();
		test.log(LogStatus.INFO, "API Response is ::" +time);
		
	}catch(Exception e) {
		test.log(LogStatus.FAIL,e.fillInStackTrace() );
	}
}

}