package jetblueScenarious;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;


public class AddstationAPI extends Base
{	
	@Test(dataProvider="AddStation")
	public void Addstation(String external_id, String name, String latitude, String longitude, String altitude, String IDName, String externalid, String stationname) throws IOException
	{
		String apikey=Base.APIkey();
		System.out.println("API key="+apikey);
		RestAssured.baseURI="http://api.openweathermap.org";
		
		String poststation=given().log().all().headers("Content-Type","application/json")
				.queryParam("appid",""+apikey+"")
		.body(Payload.Addstation(external_id,name,latitude,longitude,altitude))
		 .when().post("data/3.0/stations")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js =new JsonPath(poststation);
		String ID=js.get("ID");
		System.out.println("ID="+ID);
		String EXTERNAL_ID=js.get("external_id");
		System.out.println("EXTERNAL_ID="+EXTERNAL_ID);
		String NAME=js.get("name");		
		System.out.println("name"+name);
		Base.putvalueinhashtable(IDName,ID);
		Base.putvalueinhashtable(externalid,EXTERNAL_ID);
		Base.putvalueinhashtable(stationname,NAME);	
		

	}
	
	@DataProvider(name="AddStation")
	public Object[][] getdata()
	{
		return new Object[][] {{"DEMO_TEST001","Interview Station123","33.33","-111.43","444","First_ID","First_External_Id","First_station_name"},{"Interview1","Interview Station789","33.34","-12.44","444","Second_ID","Second_External_Id","Second_station_name"}};
	}
	
	
}
