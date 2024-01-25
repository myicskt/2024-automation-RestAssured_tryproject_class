package testCase;





import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import util.PropertyReader;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateBeareToken {
	private static String baseURI;
	private static String autheEndPoint;
	private static String authBodyFilePath;
	public static String bearerToken;

	public GenerateBeareToken() {
		baseURI = PropertyReader.getProperty("baseURI");
		autheEndPoint =PropertyReader.getProperty("auth_ENdPoint");
		authBodyFilePath = "src/main/java/data/authBody.json";
		generateBeareToken();
	}
	
	
	public static String  generateBeareToken() {
		
	//ccode missing
		
	
	}

}
