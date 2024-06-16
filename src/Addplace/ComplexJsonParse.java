package Addplace;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Print No of courses returned by API 
		
		
		JsonPath js=new JsonPath(Payload.CoursePrise());
	int count=	js.getInt("courses.size()");
	System.out.println(count);
	
	//2.Print Purchase Amount
	
	int purchaseamount = js.get("dashboard.purchaseAmount");
	
	System.out.println(purchaseamount);
		
		//3. Print Title of the first course
	String coursetile=js.get("courses[0].title");
	System.out.println(coursetile);
		
	//4. Print All course titles and their respective Prices
	for(int i=0;i<count;i++)
	{
		
	String alltitle =js.get("courses["+i+"].title");//i is a variable which is used t0 store value for perticular function
    System.out.println(alltitle);   //title=Selenium Python,price for that is 50
     int allprice=js.getInt("courses["+i+"].price");
     System.out.println(allprice);//print the  price 
	}
     //5. Print no of copies sold by RPA Course
	
	System.out.println("Print no of copies sold by RPA Course");
	
	for(int i=0; i<count;i++)//count meanse size of courses array i.e courses act as a one array
	{
	
    String title=  js.get("courses["+i+"].title");
      if(title.equalsIgnoreCase("RPA"))//to ignore the upper and lower case validation
      {
    	  int copies=  js.get("courses["+i+"].copies");//i=RPA--then only write the copies if not go out of the loop
    	  System.out.println(copies);
      }
	}
	}
}
