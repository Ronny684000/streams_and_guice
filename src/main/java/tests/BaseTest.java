package tests;

import api.RestAssuredController;
import api.RetrofitController;
import org.junit.jupiter.api.BeforeAll;
import java.util.List;
import java.util.stream.Stream;
import static utils.ConfigReader.*;

class BaseTest {

    static RetrofitController retrofitController;
    static RestAssuredController restassuredController;

    @BeforeAll
    static void setUpRetrofit() {
        retrofitController = new RetrofitController(getConfigStat("retrofit_base_url"));
    }

    @BeforeAll
    static void setUpRestAssured() {
        restassuredController = new RestAssuredController(getConfigStat("rest_assured_base_url"));
    }

    static Stream<Integer> idProvider() {
        return Stream.of(431, 440, 510);
    }

    static Stream<List<String>> filmProvider() {
        return Stream.of(
                List.of("A New Hope", "Attack of the Clones",
                        "Return of the Jedi", "The Empire Strikes Back",
                        "Revenge of the Sith", "The Phantom Menace",
                        "The Force Awakens"));
    }
}
