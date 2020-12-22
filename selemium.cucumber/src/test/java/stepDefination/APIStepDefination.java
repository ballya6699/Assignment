package stepDefination;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
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
import util.TestListener;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Listeners(TestListener.class)
public class APIStepDefination extends TestBase
{
	CSVReader csvReader = new CSVReader();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String currentDate = df.format(new Date());
	String nextDate = df.format(new Date());
	//@Test
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
	
	@BeforeMethod
	public void setUp()
	{
		init();
	}
	
	@Test
	public void TC01()
	{
		given().
		when().
			get("/latest").
		then().
		 assertThat().
		 statusCode(200);
			
	}
	
	@Test
	public void TC02()
	{
		String resp = given().
		when().
			get("/latest").
		thenReturn().
		body().
		asString();
		System.out.println(resp);
	}
	
	@Test
	public void TC03()
	{
		
		given().
		when().
			get("/latest").
		then().
		body("date", equalToIgnoringCase(currentDate));
			
	}
	
	@Test
	public void TC04()
	{
		
		given().
		when().
			get("/"+currentDate).
		then().
		assertThat().
			statusCode(200);
			
	}
	
	@Test
	public void TC05()
	{
		
		given().
		when().
			get("/"+currentDate).
		then().
		assertThat().
			statusCode(200).
			body("date", equalToIgnoringCase(currentDate));
			
	}
	
	@Test
	public void TC06() throws ParseException
	{
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(nextDate));
		c.add(Calendar.DATE, 5);
		nextDate = df.format(c.getTime());
		System.out.println("Next Date - " + nextDate);
		given().
		when().
			get("/"+nextDate).
		then().
		assertThat().
			statusCode(200).
			body("date", equalToIgnoringCase(currentDate));
			
	}
	
	
}
