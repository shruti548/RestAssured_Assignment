import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testDefinition {
	String uri = "https://reqres.in/";
	Response response;
	
	@Given("user provides API")
	public void user_provides_api() {
		RestAssured.baseURI = uri;
	    
	}

	@When("posted with correct Information")
	public void posted_with_correct_information() {
		response = RestAssured.get("https://reqres.in/");
	}
	    
	
    @Then("validate positive response code received")
	public void validate_positive_response_code_received() {

			
			response=RestAssured.given().get("https://reqres.in/api/users?page=2");
			int statuscode = response.getStatusCode();
			Assert.assertEquals(statuscode,200);          //checking success response
			response.prettyPrint();
		}

}
