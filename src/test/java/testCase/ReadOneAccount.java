package testCase;





import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import util.PropertyReader;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadOneAccount  extends GenerateBeareToken{
	private  String baseURI;
	private  String redallOneEndPoint;
	private String accountId;

	public ReadOneAccount() {
		baseURI = PropertyReader.getProperty("baseURI");
		redallOneEndPoint =PropertyReader.getProperty("getOne_ENdPoint");
		
	}
	
	
	@Test
	public void readOneAccount() {
		
		Response responce=
		
		given()
			.baseUri(baseURI)
			.header("Content-Type","application/json")
			//.header("Authorization", "Bearer "+GenerateBeareToken.generateBeareToken())
			.auth().preemptive().basic("demo1@codefios.com ", "abc123")
			.queryParam("account_id","416")

		.when()
			.get(redallOneEndPoint)
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
		
	/*
	 

"account_id": "416",
    "account_name": "gg NEW Techfios account 111",
    "account_number": "123456789",
    "description": "Test description 1",
    "balance": "100.22",
    "contact_person": "MD Islam"
}






	 */
		JsonPath jp =new JsonPath(responsebody);
		
		accountId=jp.getString("account_id");
		
		Assert.assertEquals(accountId, "416");
	
	}

}
