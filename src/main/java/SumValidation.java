import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumofCourse() {
		int sum = 0;
		JsonPath js = new JsonPath(Payload.Courseprice());
		int courseCount = js.getInt("courses.size()");
		
		for(int i=0;i<courseCount;i++) {
			
			int dashboardCount = js.getInt("courses["+i+"].price");
			int dasPurchAmt = js.getInt("courses["+i+"].copies");
			
			int amount = dashboardCount*dasPurchAmt;
			System.out.println(amount);
			sum = sum + amount;
		}
		System.out.println(sum);
	}
	
}
