import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class POST {
	
	public void test01() {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("name", "shruti");
		map.put("Job", "Test Analyst");
		System.out.println(map);
		JSONObject request= new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("content-type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(201);
	}

}
