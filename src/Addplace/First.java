package Addplace;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="http://api.example.com";
	 given().log().all().queryParam("price_max","500").header("Content-Type","application/json")
	 .body("{\r\n"
	 		+ "  \"name\": \"New Product\",\r\n"
	 		+ "  \"category\": \"Home & Garden\",\r\n"
	 		+ "  \"price\": 149.99\r\n"
	 		+ "}\r\n"
	 		+ "")
	 .when().post("/api/products")
	 .then().log().all().assertThat().statusCode(200);

}
}