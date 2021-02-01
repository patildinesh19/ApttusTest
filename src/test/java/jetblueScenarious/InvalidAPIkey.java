package jetblueScenarious;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidAPIkey 

{	// ----------API First Scenario---------
	
	@Test(dataProvider="AddStation")
	public void invalisdapikey(String external_id, String name, String latitude, String longitude, String altitude, String invalidmessage, int statuscode)
	{
		RestAssured.baseURI="http://api.openweathermap.org";
		
		String Addbookresponce=given().log().all().headers("Content-Type","application/json")
				.queryParam("appid", "0f1c05f9b3ceb98ce003f9ba255205")
		.body(Payload.Addstation(external_id,name,latitude,longitude,altitude))
		 .when().post("data/3.0/stations")
		.then().log().all().assertThat().statusCode(401).extract().response().asString();
		
		JsonPath js =new JsonPath(Addbookresponce);		
		Assert.assertEquals(js.get("cod"),statuscode);		
		Assert.assertEquals(js.get("message"),invalidmessage);

	}
	
	@DataProvider(name="AddStation")
	public Object[][] getdata()
	{
		return new Object[][] {{"SH_TES11U2J","TestMN90 Station","39.76","-102.43","190","Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.",401}};
	}
	
}
