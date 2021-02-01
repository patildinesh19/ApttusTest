package jetblueScenarious;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;

import Resources.Base;

public class deletestationAPI extends Base
{
	@Test	
	public void deletestation() throws IOException
	{
		String apikey=Base.APIkey();
		String First_ID=Base.getvalufromhashtable("First_ID");
		System.out.println("Delete_expected_First_ID"+First_ID);
		String Second_ID=Base.getvalufromhashtable("Second_ID");
		
		System.out.println("deleted_expected_Second_ID"+Second_ID);
		
		RestAssured.baseURI="http://api.openweathermap.org";
		
		//delete First station
		given().log().all().headers("Content-Type","application/json")
		.queryParam("appid",""+apikey+"")					
		.when().delete("data/3.0/stations/"+First_ID+"")
		.then().log().all().assertThat().statusCode(204).extract().response().asString();
		
		// delete second station
		given().log().all().headers("Content-Type","application/json")
		.queryParam("appid",""+apikey+"")					
		.when().delete("data/3.0/stations/"+Second_ID+"")
		.then().log().all().assertThat().statusCode(204).extract().response().asString();
		
		
	}
}
