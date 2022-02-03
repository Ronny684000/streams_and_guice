package tests;

import models.Currency;
import models.Rate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.util.Optional;

class BankTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"USD", "EUR", "RUB"})
    void case1(String abbreviation) throws IOException {
        Optional<Currency> curr = retrofitController.getAllCurrencies().stream()
                .filter(currency -> currency.getCur_Abbreviation().equals(abbreviation))
                .findFirst();
        assertThat(curr.isPresent()).isTrue();
        System.out.println("Name for " + abbreviation + " is " + curr.get().getCur_Name_Eng());
    }

    @ParameterizedTest
    @MethodSource("idProvider")
    void case2(int id) throws IOException {
        Optional<Currency> curr = retrofitController.getAllCurrencies().stream()
                .filter(currency -> currency.getCur_ID() == id)
                .findFirst();
        assertThat(curr.isPresent()).overridingErrorMessage("There is no currency with such id")
                .isTrue();
        Optional<Rate> rate = Optional.ofNullable(retrofitController.getRateOf(id));
        assertThat(rate.isPresent()).overridingErrorMessage("There is no rate for that currency")
                .isTrue();
        System.out.println("Rate for " + curr.get().getCur_Name_Eng() + " is " + rate.get().getCur_OfficialRate());
    }
}
