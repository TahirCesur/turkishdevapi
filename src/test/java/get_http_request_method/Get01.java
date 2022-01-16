package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 extends HerokuappBaseUrl {

    /*
    Gherkin key words

    *GIVEN   => Baslangic islemini temsil eder. pre-requisite..
    Yani postmana url yi girmektir diyebiliriz..

    *WHEN    => Islemin action kismini tanimlar..
    Yani CRUD işlemlerinden birirni seçmektir diyebiliriz..

    *AND     => Tekrar eden islemleri gosterir..
    Yani json olup olmadigini secme diyebiliriz..

    *THEN    => Islemin sonunu ve validation u gosterir..
    Yani status kodunu gormektir..
    */

    /*
    Given
           https://restful-booker.herokuapp.com/booking/3
    When
         user sends a request to the url
    Then
         HTTP Status code should be 200
    And
         ContentType should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void get01(){
        String endpoint = "https://restful-booker.herokuapp.com/booking/3";
        // Organize bir yol degil...Bu yol cok tercih edilmeyecek...
        Response response = given().when().get(endpoint);
        response.prettyPrint();
    }

     /*
    Given
           https://restful-booker.herokuapp.com/booking/3
    When
         user sends a request to the url
    Then
         HTTP Status code should be 200
    And
         ContentType should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void test(){
        /*
        Not : extend edince Herokuappbaseurl e asagidaki bilgilere gerek kalmadi...

        // 1. asama ; Given --> Set the url / urli set et
        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
        */
        spec.pathParams("bir", "booking","iki", 3);


        // /{bir}/{iki}
        // 2. asama ; When --> Get request yap ve Response al
        Response response = given().spec(spec).when().get("/{bir}/{iki}");
        // response.prettyPrint();

        // 3. asama ; Then --> Validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
        // Bunları 51 ve 61 arasindaki satirlar arasından alip ekledik...
    }
}