package jetblueScenarious;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import junit.framework.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;

public class getstationinfoAPI extends Base
{		
	
	@Test	
	public void getstationinfo() throws IOException	
	{	
	String apikey=Base.APIkey();
	String First_ID=Base.getvalufromhashtable("First_ID");
	System.out.println("First_ID"+First_ID);
	String First_External_Id=Base.getvalufromhashtable("First_External_Id");
	System.out.println("First_External_Id"+First_External_Id);
	String First_station_name=Base.getvalufromhashtable("First_station_name");
	System.out.println("First_station_name"+First_station_name);
	String Second_ID=Base.getvalufromhashtable("Second_ID");
	System.out.println("Second_ID"+Second_ID);
	String Second_External_Id=Base.getvalufromhashtable("Second_External_Id");
	System.out.println("Second_External_Id"+Second_External_Id);
	String Second_station_name=Base.getvalufromhashtable("Second_station_name");
	System.out.println("Second_station_name"+Second_station_name);
		RestAssured.baseURI="http://api.openweathermap.org";
		
		String getstationdetails=given().log().all().headers("Content-Type","application/json")
		.queryParam("appid", ""+apikey+"")			
		.when().get("data/3.0/stations")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js =new JsonPath(getstationdetails);
		
		String ID=js.get("[0].id");
		System.out.println("First_Id:"+ID);		
		Assert.assertEquals(ID,First_ID);
		
		String FirstExternalId=js.get("[0].external_id");
		System.out.println("FirstExternalId:"+FirstExternalId);		
		Assert.assertEquals(FirstExternalId,First_External_Id);
		
		String first_name=js.get("[0].name");
		System.out.println("first_name:"+first_name);		
		Assert.assertEquals(first_name,First_station_name);
		
		String ID1=js.get("[1].id");
		System.out.println("First_ID1:"+ID1);		
		Assert.assertEquals(ID1,Second_ID);
		
		String FirstExternalId1=js.get("[1].external_id");
		System.out.println("FirstExternalId1:"+FirstExternalId1);		
		Assert.assertEquals(FirstExternalId1,Second_External_Id);
		
		String first_name1=js.get("[1].name");
		System.out.println("first_name1:"+first_name1);		
		Assert.assertEquals(first_name1,Second_station_name);		
	}
	
	
}
