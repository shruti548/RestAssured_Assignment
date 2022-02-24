
	
    
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	
public class parsing {
	String uri = "https://reqres.in/";
	Response response;
	
	@Given("user provides sample API")
	public void user_provides_sample_api() {
		RestAssured.baseURI = uri;  
	}

	@When("posted with correct Information")
	public void posted_with_correct_information() {
		response = RestAssured.get("https://reqres.in/");   
	}

	@Then("validate response and log it on console")
	public void validate_response_and_log_it_on_console() {
		//store response into response object
		response = RestAssured.given()
				   .headers("Content-type","application/json")
				   .log().all()
				   .get("https://reqres.in/api/users?page=2")
				   .then()
				   .assertThat()
				   .statusCode(200)
				   .log().all()                        //logging console
				   .extract().response();  
	}
	


}
