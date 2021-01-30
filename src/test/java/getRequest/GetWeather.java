package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetWeather {

    @Test
    public void testResponseCode() {

        String apiKey = System.getenv("API_KEY");

        Response resp =  RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey );

        int statusCode = resp.getStatusCode();

        System.out.println("Status code is "+statusCode);

        Assert.assertEquals(statusCode,200);
    }

}
