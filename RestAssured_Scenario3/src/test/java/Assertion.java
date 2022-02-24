


import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assertion {
	String uri ="https://reqres.in/" ;
	Response response;
	
	@Given("user provides API")
	public void user_provides_api() {
		RestAssured.baseURI = uri;
	    
	}

	@When("use pass values with the help of get method")
	public void use_pass_values_with_the_help_of_get_method() {
		RequestSpecification httpRequest = RestAssured.given();
		response= httpRequest.request(Method.GET, "api/users");
		
	}

	@Then("use validates that response received")
	public void use_validates_that_response_received() {
		
		response = RestAssured.given().get("api/users");
		
		int StatusCode= response.getStatusCode();
		Assert.assertEquals(StatusCode, 200);
		String header = response.getHeader("Content-type");
		Assert.assertTrue(header.contains("application/json"));   
	}

}
