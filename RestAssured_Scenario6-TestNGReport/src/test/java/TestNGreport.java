import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestNGreport {
String uri="https://reqres.in";
Response response;


@DataProvider(name= "test")
public Object[][] data_provider(){
	Object[][] data= new Object[3][3];
	
	data[0][0]= "Max";
	data[0][1]= "stewart";
	data[0][2]= "12";
	
	data[1][0]= "John";
	data[1][1]= "pol";
	data[1][2]= "32";
	
	data[2][0]= "Matt";
	data[2][1]= "well";
	data[2][2]= "10";
	
	return data;
}

@Test

@Given("user provides API")
public void test_given() {
	RestAssured.baseURI="https://reqres.in";
	}

@Test

@When("When posted with parametrized Information")
public void test_When(String firstName, String lastName, String id) {
	response= RestAssured.get("api/users?page=2"+firstName+"-"+lastName+"-"+id);
	}

@Test

@Then("validate multiple records and display reports")
public void test_then(String firstName, String lastName, String id) {
	response= RestAssured.given().get("\"api/users?page=2\"+firstName+\"-\"+lastName+\"-\"+id");
	String status= response.getStatusLine();
	Assert.assertTrue(status.contains("OK"));
	System.out.println(status);
}

}
