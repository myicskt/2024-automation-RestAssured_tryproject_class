package testCase;





import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import util.PropertyReader;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadallAccount  extends GenerateBeareToken{
	private  String baseURI;
	private  String redallEndPoint;
	private String firstAccountId;

	public ReadallAccount() {
		baseURI = PropertyReader.getProperty("baseURI");
		redallEndPoint =PropertyReader.getProperty("getAll_ENdPoint");
		
	}
	
	
	@Test
	public void readAllAccount() {
		
		Response responce=
		
		given()
			.baseUri(baseURI)
			.header("Content-Type","application/json")
			.header("Authorization", "Bearer "+GenerateBeareToken.generateBeareToken())
			

		.when()
			.get(redallEndPoint)
		.then()
			//.log().all()
			.extract().response()
			
			;
		
		int statuscode =responce.getStatusCode();
		String responseHeaderTyep =responce.getHeader("Content-Type");
		long timeMilliSec=responce.getTimeIn(TimeUnit.MILLISECONDS);
	
	
		Assert.assertEquals(statuscode,200);
		
		
		
		Assert.assertEquals(responseHeaderTyep,"application/json");
		
		if(timeMilliSec<=2000) {
			System.out.println("response time is within range");
			
		}else {
			System.out.println("response time is out of range");
		}
		
		String responsebody=responce.body().asString();
		
	
		JsonPath jp =new JsonPath(responsebody);
		
		firstAccountId=jp.getString("records[0].account_id");
		
		
		Assert.assertNotNull(firstAccountId);
	
	}

}
