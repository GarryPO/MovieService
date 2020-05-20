import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.basic;

/**
 * Base test class to hold test configuration
 */
public class BaseTest {


    @BeforeClass
    public void setup(){
        RestAssured.authentication = basic("artem", "ap1234");
        RestAssured.baseURI = "http://3.84.187.196:8081/api/movieservice/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());





    }

}
