package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    // Not: Get01 class tan 71 ve 72. satiri buraya alip extend etmis olduk...

    protected RequestSpecification spec;

    @Before // Birseyi test etmeden once @Before annotation u kullaniriz...
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}