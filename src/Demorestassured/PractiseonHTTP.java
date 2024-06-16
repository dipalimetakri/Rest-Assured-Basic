package Demorestassured;





		import io.restassured.RestAssured;

		import io.restassured.path.json.JsonPath;

		import static io.restassured.RestAssured.*;
		import  static org.hamcrest.Matchers.*;
		//machers is a subpackage comes under hamcrest
		
		public class PractiseonHTTP {	
			


			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				//given - all input details 
				//when - Submit the API -resource,http method
				//Then - validate the response
				
		   RestAssured.baseURI="https://rahulshettyacademy.com";
		     
		 String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		      .body("{\r\n"
		    		+ "  \"location\": {\r\n"
		   		    + "    \"lat\": -38.383494,\r\n"
		   	    	+ "    \"lng\": 33.427362\r\n"
		 	        + "  },\r\n"
		        	+ "  \"accuracy\": 50,\r\n"
		         	+ "  \"name\": \"Sonali Metkari\",\r\n"
		     		+ "  \"phone_number\": \"(+91) 9921845429\",\r\n"
		      		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
		        	+ "  \"types\": [\r\n"
		        	+ "    \"shoe park\",\r\n"
		     		+ "    \"shop\"\r\n"
		     		+ "  ]\r\n"
		     		+ "}\r\n"
		 		+ "  ")
		    .when().post("/maps/api/place/add/json")
		     .then().log().all().statusCode(200).extract().response().asString();
		    System.out.println(response);
		 
		    JsonPath js=new JsonPath(response); // convert string into JSON format
		    String placeid= js.getString("place_id");
		    
		    //GET
		     
		    
		   given().log().all().queryParam("key","qaclick123").queryParam( "place_id",placeid)
		  
		    .when().get("/maps/api/place/get/json")
		     .then().log().all().assertThat().statusCode(200).extract().response().asString();
		   
		   //Update
		   given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeid)
		   .body("{\r\n"
		   		+ " \"place_id\":\""+placeid+"\",\r\n" //to place variable into string we need to add double quote + + double quote
		   		+ " \"address\":\"70 winter walk, USA\",\r\n"
		   		+ " \"key\":\"qaclick123\"\r\n"
		   		+ "}").when().put("/maps/api/place/update/json").then().log().all().assertThat()
		   .statusCode(200).body("msg", equalTo("Address successfully updated"));
		 //equal to= comes under static package not showing autosuggestion so need to import harmcrest package.
		   
		   //Delete

		   
		   given().log().all().queryParam("key","qaclick")
		   .body("{\r\n"
		   		+ " \"place_id\":\""+placeid+"\"\r\n"
		   		+ "}").when().delete("/maps/api/place/delete/json")
		   .then().log().all().assertThat().statusCode(200).body("status", equalTo("OK")).extract().response().asString();
		   
		   
		//.  given().log().all().queryParam("key", "qaclick").body("place_id",placeid).when()
		     
			}

		

	}


