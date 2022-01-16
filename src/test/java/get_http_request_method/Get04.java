package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {

     /* Soru :

        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04(){

        // 1. asama ; Given --> Set the url / urli set et
        spec.pathParam("bir", "todos" );

        //Set the expected data / beklenen datayi olustur

        // 2. asama ; When --> Get request yap ve Response al
        Response response = given().spec(spec).when().get("/{bir}");

        // 3. asama ; Then --> Validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("id",hasSize(200)).
                body("title",hasItem("quis eius est sint explicabo")).
                body("userId", hasItems(2,7,9));

        // hasSize : 200 adet veri var mı kontrol eder..
        // hasItem : Direk yazılanı kontrol eder...
        // hasItems : Birden fazla veriyi kontrol eder...
    }
}
