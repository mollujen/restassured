import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawtojson(String response){
		
		System.out.println("raw to json: " +response);
		
		JsonPath js1 = new JsonPath(response);
		
		return js1;
		
	}
}
