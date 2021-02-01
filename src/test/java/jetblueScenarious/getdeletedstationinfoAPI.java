package jetblueScenarious;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;

public class getdeletedstationinfoAPI extends Base
{
	@Test(dataProvider="verifyresponceboday")	
	public void getdeletedstationinfo(String message, int statscode) throws IOException
	{
		String apikey=Base.APIkey();
		String First_ID=Base.getvalufromhashtable("First_ID");
		String Second_ID=Base.getvalufromhashtable("Second_ID");
		
		System.out.println("expected_First_ID"+First_ID);
		
		RestAssured.baseURI="http://api.openweathermap.org";
		
		//First station verification after delete it
		
		String getstationdetails=given().log().all().headers("Content-Type","application/json")
						.queryParam("appid",""+apikey+"")	
				
		.when().get("data/3.0/stations/"+First_ID+"")
		.then().log().all().assertThat().statusCode(404).extract().response().asString();
		JsonPath js =new JsonPath(getstationdetails);
		int actualstatscode=js.get("code");
		String actualmessage=js.get("message");
		System.out.println("statscode: "+statscode);
		System.out.println("message : "+message);
		Assert.assertEquals(actualmessage, message);
		Assert.assertEquals(actualstatscode, statscode);
		//Second station verification after delete it
		
		String getsecondstation=given().log().all().headers("Content-Type","application/json")
				.queryParam("appid", ""+apikey+"")	
		
				.when().get("data/3.0/stations/"+Second_ID+"")
				.then().log().all().assertThat().statusCode(404).extract().response().asString();
		JsonPath js1 =new JsonPath(getsecondstation);
		int second_station_statscode=js1.get("code");
		String second_station_message=js1.get("message");
		System.out.println("statscode: "+statscode);
		System.out.println("message : "+message);
		Assert.assertEquals(second_station_message, message);
		Assert.assertEquals(second_station_statscode, statscode);		
	}
	
	@DataProvider(name="verifyresponceboday")
	public Object[][] getdata()
	{
		return new Object[][] {{"Station not found",404001}};
	}
	
}
