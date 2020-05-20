import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.hamcrest.Matchers.*;


@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Movie {
    private int Year;
    private String Director;
    private String Title;

    public ResponseSpecification MovieSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .expectBody("Year",equalTo(this.getYear()))
                .expectBody("Director",equalTo(this.getDirector()))
                .expectBody("Title",equalTo(this.getTitle()));

        return builder.build();
    }
}
