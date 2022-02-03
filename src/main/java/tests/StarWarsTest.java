package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.ApiUtils.*;
import static utils.RandomUtils.*;

public class StarWarsTest extends BaseTest {

    private static final String CHECKING_DATE = "1990-01-01";

    @ParameterizedTest
    @MethodSource("filmProvider")
    void case3(List<String> filmNames) {
        assertThat(checkContainsList(restassuredController.getFilms(), filmNames))
                .overridingErrorMessage("Films are not match").isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void case4(int filmId) {
        assertThat(checkReleaseDate(restassuredController.getFilm(filmId), CHECKING_DATE))
                .overridingErrorMessage("The film was shot later").isTrue();
    }

    @Test
    void case5() {
        assertThat(checkHasFilms(restassuredController.getPeople(getRandomNumber(10))))
                .overridingErrorMessage("This people does not have any films").isTrue();
    }
}
