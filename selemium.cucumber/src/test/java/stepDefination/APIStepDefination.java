package stepDefination;

import org.testng.annotations.Test;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.CSVReader;
import util.TestBase;

/*import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;*/

import java.io.IOException;

public class APIStepDefination extends TestBase
{
	CSVReader csvReader = new CSVReader();
	@Test
	public void getTheAPIResponce() throws IOException, JSONException
	{
		
		Object[] URI = csvReader.readFile("First.csv").toArray();
		Object[] URIS = csvReader.readFile("Second.csv").toArray();
		
		for (int i=0; i<URI.length; i++) 
		{
			/*System.out.println(URI[i]);
			System.out.println(URIS[i]);*/
			
			compareAPI(URI[i],URIS[i]);
		}
		
	}
	public void compareAPI(Object uRI, Object uRIS) throws IOException, JSONException 
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(uRI.toString());
		Response response1 = httpRequest.get(uRIS.toString());


		String body = response.getBody().asString();
		String body1 = response1.getBody().asString();
		//JSONAssert.assertEquals(body, body1, JSONCompareMode.STRICT);
		
		JSONCompareResult result = JSONCompare.compareJSON(body, body1, JSONCompareMode.STRICT);
		System.out.println("Result ********** " + result.toString());
	}
	
	
}
