import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GET {
	
	@Test

	public void test() {
	given().get("https://reqres.in/api/users").
	then().statusCode(200).body("data.id[2]", equalTo(3)).body("data.first_name", hasItems("Emma","Michael"))
	.log().all();

}
}
