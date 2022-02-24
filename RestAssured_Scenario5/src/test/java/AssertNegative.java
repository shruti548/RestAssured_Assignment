import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AssertNegative {
	String uri = "https://reqres.in/";
	Response response;
	
	@Given("user provides API")
	public void user_provides_api() {
		
		RestAssured.baseURI = uri;
	    
	}

	@When("posted with correct Information")
	public void posted_with_correct_information() {
		response = RestAssured.given().get("api/unknown/23"); 
	}

	@Then("validate response status code received")
	public void validate_response_status_code_received() {
		response = RestAssured.given().get("api/users?delay=3");     //negative scenario
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);           //assertion--- negative scenario
		
		String text = response.getStatusLine();
		Assert.assertTrue(text.contains("Not Found"));
	    
	}


}
