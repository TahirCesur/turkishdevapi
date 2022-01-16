package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends HerokuappBaseUrl {


        /* Soru :

            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Jim" and last name is "Jones"
        */

    @Test
    public void get05() {

        // 1. asama ; Given --> Set the url / urli set et
        spec.pathParam("bir", "booking").queryParams("firstname", "Jim", "lastname", "Jones");

        //Set the expected data / beklenen datayi olustur

        // 2. asama ; When --> Get request yap ve Response al
        Response response = given().spec(spec).when().get("/{bir}");

        response.prettyPrint(); // [ ]

        // 3. asama ; Then --> Validation
        response.then().assertThat().statusCode(200);
    }
}