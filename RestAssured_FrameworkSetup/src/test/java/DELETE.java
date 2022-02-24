import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

	public class DELETE {
		@Test
		public void test_01() {
			Response res =given().
				delete("https://reqres.in/api/users/2").
			then().
				statusCode(204).
				log().all().
				extract().response();
			}
	}
