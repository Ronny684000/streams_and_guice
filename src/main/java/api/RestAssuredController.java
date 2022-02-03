package api;

import com.google.gson.Gson;
import data.ApiUrl;
import io.restassured.RestAssured;
import models.Film;
import models.FilmsResponse;
import models.People;
import java.util.Arrays;
import java.util.List;

public class RestAssuredController {

    public RestAssuredController(String url) {
        RestAssured.baseURI = url;
    }

    public List<Film> getFilms() {
        String response = RestAssured.given().when()
                .get(ApiUrl.FILMS.getUrl()).then().extract().body().asString();
        FilmsResponse targetObject = new Gson().fromJson(response, FilmsResponse.class);
        return Arrays.asList(targetObject.getResults());
    }

    public Film getFilm(int id) {
        String response = RestAssured.given().when().pathParam("id", id)
                .get(ApiUrl.CONCRETE_FILM.getUrl()).then().extract().body().asString();
        return new Gson().fromJson(response, Film.class);
    }

    public People getPeople(int id) {
        String response = RestAssured.given().when().pathParam("id", id)
                .get(ApiUrl.CONCRETE_PEOPLE.getUrl()).then().extract().body().asString();
        return new Gson().fromJson(response, People.class);
    }
}
