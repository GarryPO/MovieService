import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;


/**
 * Simple test class containing example test cases against basic CRUD operations
 */
public class SimpleTest extends BaseTest {

    private Movie horror;
    private ResponseSpecification specification;
    private  String id;



    @Test(priority = 0)
    public void validateJsonShceme(){
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("1")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/movie_1.json")));
    }

    @Test(priority = 0)
    public void createMovie(){
        horror = Movie.builder()
                .Director("Piter Pan")
                .Year(2020)
                .Title("Very strange movie")
                .build();

         specification = horror.MovieSpec();
         id =
                given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(horror, ObjectMapperType.GSON)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                        .body().as(String.class);


            System.out.println(id);


}


    @Test(priority = 0)
    public void  getMovie(){

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(id)
                .then()
                .statusCode(200)
                .spec(specification);


    }


    @Test(priority = 1)
    public  void  updateMovie(){
        horror.setTitle("Different title");
        specification = horror.MovieSpec();
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(horror,ObjectMapperType.GSON)
                .when()
                .put(id)
                .then()
                .statusCode(200);


        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(id)
                .then()
                .statusCode(200)
                .spec(specification);


    }

    @Test(priority = 2)
    public  void deleteMovie(){
            given().accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .when()
                    .delete(id)
                    .then()
                    .statusCode(200);


            given().accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(id)
                    .then()
                    .statusCode(204);

        }
    @Test
    public void getOldMovie(){

       Movie oldMovie = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("5")
                .then()
                .extract().body().as(Movie.class, ObjectMapperType.GSON);
        Assert.assertTrue(oldMovie.getDirector().equals("Martin Scorsese"));
        //System.out.println(oldMovie.toString());
    }


}
