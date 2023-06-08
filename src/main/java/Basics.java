import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// given - submit all details
		// when - submit the api using methods with response
		// then - validate response

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.reqbody()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).header("Server", equalTo("Apache/2.4.41 (Ubuntu)")).extract().response().asString();
		System.out.println("Changed to String " + response);

		JsonPath jsp = ReusableMethods.rawtojson(response);
		String placeid = jsp.getString("place_id");
		System.out.println(placeid);

		String putresponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
				.header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"GVRA 021 MT Cottage\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("/maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).extract().response().asString();
		System.out.println("Changed to String " + putresponse);

		String getresponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().assertThat()
				.statusCode(200).body("address", equalTo("GVRA 021 MT Cottage")).extract().response().asString();
		System.out.println("GetResponse" + getresponse);

//		String deleteresponse = given().log().all().queryParam("key", "qaclick123")
//				.header("Content-Type", "application/json")
//				.body("{\r\n" + "    \"place_id\":\"" + placeid + "\"\r\n" + "}\r\n" + "").when()
//				.delete("/maps/api/place/delete/json").then().assertThat().statusCode(200).body("status", equalTo("OK"))
//				.extract().response().asString();
//		System.out.println("deleteresponse " + deleteresponse);
		
	    JsonPath jsp1 =ReusableMethods.rawtojson(getresponse);
		String address = jsp1.getString("address");
		System.out.println(address);
		Assert.assertEquals("GVRA 021 MT Cottage", address);
		
	}

}
