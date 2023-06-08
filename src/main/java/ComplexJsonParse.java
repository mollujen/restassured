import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(Payload.Courseprice());
		int courseCount = js.getInt("courses.size()");
		System.out.println("size of the course :" + courseCount);

		int dashboardCount = js.getInt("dashboard.size()");
		System.out.println("size of the dashboard :" + dashboardCount);

		int dasPurchAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println("The amount of dashboard's purchase amount is :" + dasPurchAmt);

		String website = js.getString("dashboard.website");
		System.out.println("The name of the website is :" + website);

		String courseTitle = js.getString("courses[0].title");
		System.out.println("The course title is :" + courseTitle);

		int coursePrice = js.getInt("courses[2].price");
		System.out.println("The course price is " + coursePrice);
		
		for(int i = 0; i<js.getInt("courses.size()"); i++) {
			System.out.println("The "+i+"th course tiltle is :" + js.getString("courses["+i+"].title"));
			System.out.println("The "+i+"th course tiltle is :"+ js.getInt("courses["+i+"].price"));
			System.out.println("The "+i+"th course tiltle is :"+ js.getInt("courses["+i+"].copies"));
		}

//		for(int i=0; i<courseCount; i++) {
//			System.out.println();
//		}
	}

}
