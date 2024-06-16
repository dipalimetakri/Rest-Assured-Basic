package Addplace;





import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	
	public void amount()
	{

		JsonPath js=new JsonPath(Payload.CoursePrise());
		int count=js.get("courses.size[]");
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<count;i++)
		{
			
			int price =js.getInt("courses["+i+"].price");
			int copies  =js.getInt("courses["+i+"].copies");
			int Purchaseamount = price*copies ;
			System.out.println(Purchaseamount);
			 sum=sum+Purchaseamount; //0+33,sum=33,33+323 sum=356
			
		}
		System.out.println(sum);
}
}