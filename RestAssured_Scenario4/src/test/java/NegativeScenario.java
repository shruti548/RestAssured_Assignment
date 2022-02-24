import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class NegativeScenario {
	
	
	String uri = "https://reqres.in/";
	Response response;
	
	@Given("user provides API")
	public void user_provides_api() {
		RestAssured.baseURI = uri;  
	}

	@When("posted with correct Information")
	public void posted_with_correct_information() {
		response = RestAssured.given().get("api/users/23");    //store response into response object
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode != 200); //check for negative scenario
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		RestAssured.given().headers("content-Type","application/json")
		   .get("api/users/23")             //negative scenario
		   .then()
		   .assertThat()
		   .statusCode(400)         
		   .log().all();            //log into console
	    
	}
}
