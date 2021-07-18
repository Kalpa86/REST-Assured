package tests;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
//import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		
		
		File file = new File("./SOAPRequest/Add.xml");
		
		if(file.exists())
			System.out.println("  >> File exists");
		
		FileInputStream oFileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(oFileInputStream, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("calculator.asmx").
		then().
			statusCode(200).log().all().and().body("//AddResult.text()", equalTo("5"));
		
	}

}
 