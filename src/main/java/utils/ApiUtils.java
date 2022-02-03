package utils;

import models.Film;
import models.FilmsResponse;
import models.People;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ApiUtils {

    public static boolean checkReleaseDate(Film film, String date) {
        LocalDate wrappedDate = LocalDate.parse(date);
        return LocalDate.parse(film.getRelease_date()).isBefore(wrappedDate);
    }

    public static boolean checkContainsList(List<Film> filmsResponse, List<String> filmNames) {
        Set<String> realFilmsList = filmsResponse.stream().map(Film::getTitle)
                .collect(Collectors.toSet());
        Set<String> filmNamesSet = new HashSet<>(filmNames);
        filmNamesSet.removeAll(realFilmsList);
        return filmNamesSet.isEmpty();
    }

    public static boolean checkHasFilms(People people) {
        return !Arrays.asList(people.getFilms()).isEmpty();
    }
}
