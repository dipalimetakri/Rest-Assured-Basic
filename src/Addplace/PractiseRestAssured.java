package Addplace;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class PractiseRestAssured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		String practise = given().log().all().queryParam("key", "qaclick").queryParam("place_id", "660642242d40a07bad61f9141c5f0363e")
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(404).extract().response().asString();
		
		System.out.println(practise);
	}
}
