package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetWeather {

    @Test
    public void testResponseCode() {

        String apiKey = System.getenv("API_KEY");

        Response resp =  get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey);

        int statusCode = resp.getStatusCode();

        System.out.println("Status code is "+statusCode);

        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void testBody() {

        String apiKey = System.getenv("API_KEY");

        Response resp =  get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey );

        String body = resp.asString();

        System.out.println("Status code is "+body);
        System.out.println("Response time "+resp.getTime());
    }

}
