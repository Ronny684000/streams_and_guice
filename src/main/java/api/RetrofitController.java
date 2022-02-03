package api;

import com.google.gson.GsonBuilder;
import models.Currency;
import models.Rate;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class RetrofitController implements Callback {

    private BankApi api;

    public RetrofitController(String baseUrl) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(httpClient.build()).build();
        api = retrofit.create(BankApi.class);
    }

    @Override
    public void onResponse(Call call, Response response) {
        if(response.isSuccessful()) {
            System.out.println(response.body());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call call, Throwable error) {
        error.printStackTrace();
    }

    public List<Currency> getAllCurrencies() throws IOException {
       return api.getAllCurrencies().execute().body();
    }

    public Rate getRateOf(int id) throws IOException {
        return api.getRateOf(id).execute().body();
    }


}
