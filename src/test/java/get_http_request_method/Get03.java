package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /* Soru :

       Given
           https://jsonplaceholder.typicode.com/todos/23
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
       And
           “completed” is false
       And
           “userId” is 2
    */

    @Test
    public void get03(){

        // 1. asama ; Given --> Set the url / urli set et
        spec.pathParams("bir", "todos", "iki",23 );

        //Set the expected data / beklenen datayi olustur

        // 2. asama ; When --> Get request yap ve Response al
        Response response = given().spec(spec).when().get("/{bir}/{iki}");

        // 3. asama ; Then --> Validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));

        // Bu sekilde de body leri icice yazabiliriz...
        response.then().assertThat().body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                "completed", equalTo(false),"userId", equalTo(2) );
    }
}