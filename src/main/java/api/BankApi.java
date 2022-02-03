package api;

import models.Currency;
import models.Rate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface BankApi {

    @GET("currencies")
    Call<List<Currency>> getAllCurrencies();

    @GET("rates/{id}")
    Call<Rate> getRateOf(@Path("id") int id);
}
