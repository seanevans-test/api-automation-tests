package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetWeather {

    @Test
    public void testResponseCode() {

        String apiKey = System.getenv("API_KEY");

        int statusCode = get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey).getStatusCode();

        System.out.println("Status code is "+statusCode);

        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void testBody() {

        String apiKey = System.getenv("API_KEY");

        String body = get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey ).asString();
        long time = get("http://api.openweathermap.org/data/2.5/weather?q=Paris,France&appid=" + apiKey ).getTime();

        System.out.println("Response time "+time);
    }

}
