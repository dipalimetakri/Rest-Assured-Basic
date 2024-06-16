package typeofPostreqbodycreation;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured .*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Postbodyreqcreation {
	
	@Test
	
	
	public void hashmap() {
		
		
		HashMap data=new HashMap(); //needs to import java.util package
		data.put("name", "Dipali");
		data.put("Lastname", "Metkari");
		data.put("location", "Piliv");
		data.put("age", "23");
		
		
		//to pass the string 1st we need to store it into another variable and then import.
		
		String courseArr[]= {"c++","c#","RestAsured API"};
		
		data.put("Courses", courseArr);
		
		given().contentType("application/json").body(data)
		.when().post("/maps/api/place/add/json")
		.then().statusCode(201)
		.body("name", equalTo("Dipali"))
		.body("Lastname", equalTo("Metkari"))
		.body("Courses",equalTo(courseArr)).log().all();
		
	}

}
