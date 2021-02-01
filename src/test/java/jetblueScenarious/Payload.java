package jetblueScenarious;

public class Payload 
{	//----------below method used for sending values to request body-------
	public static String Addstation(String external_id, String name,
			String latitude, String longitude, String altitude)
	{
		String addbookpayload="{\r\n" + 
				"  \"external_id\": \""+external_id+"\",\r\n" + 
				"  \"name\": \""+name+"\",\r\n" + 
				"  \"latitude\": "+latitude+",\r\n" + 
				"  \"longitude\": "+longitude+",\r\n" + 
				"  \"altitude\": "+altitude+"\r\n" + 
				"}";
				return addbookpayload;
	}
}
