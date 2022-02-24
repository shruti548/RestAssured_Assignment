
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class PUT {
	@Test
	public void put_test () {
	Response res =	given().
				header("Content-Type","application/json").
				body("{\r\n"
						+ "    \"name\": \"Max\",\r\n"
						+ "    \"job\": \"analyst\"\r\n"
						+ "}").
		when().
				put("https://reqres.in/api/users/2").
		
		then().
				statusCode(200).
				log().all().
				extract().response();
		
	}
	
	public void put_test2_negative() {
		Response res =	given().
				header("Content-Type","application/json").
				body("{\r\n"
						+ "    \"name\": \"John\",\r\n"
						+ "    \"job\": \"HR\"\r\n"
						+ "}").
		when().
				put("https://reqres.in/api/users/2").
		
		then().
				statusCode(301).
				log().all().
				extract().response();
	}
}