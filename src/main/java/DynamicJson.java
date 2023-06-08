import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicJson {

	@Test
	public void addBook() {
		
		String response = RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type","application/json").body(Payload.addBook())
		.when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethods.rawtojson(response);
		String id = js.get("ID");
		System.out.println(id);
		
	
	}
}
