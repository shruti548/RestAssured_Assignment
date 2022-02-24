import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeDetail {
	String uri="http://reqres.in";
	Response response;
	
	@Test
	public void getEmpDetail() {
		RestAssured.baseURI=uri;
		
		RequestSpecification httpsRequest= RestAssured.given();
		response=httpsRequest.request(Method.GET, "employees");
		response.prettyPrint(); //print body
		
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is :"+StatusCode);
	}
		
	@Test
	public void invalidEmployeeDetail() {
		RestAssured.baseURI=uri;
		response=RestAssured.given().get("employees/20");
		int StatusCode= response.getStatusCode();
		Assert.assertEquals(StatusCode, 200);
	}

}
