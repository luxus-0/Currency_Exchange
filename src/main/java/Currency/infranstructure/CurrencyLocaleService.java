package Currency.infranstructure;


import Currency.domain.service.CurrencyLocale;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface CurrencyLocaleService {

    @GET("/getCurrenciesLocale")
    Call<List<CurrencyLocale>> getCurrencyLocale();

    @GET("/getCurrenciesLocale/{name}")
    Call<List<CurrencyLocale>> getCurrencyLocaleByName(@Path("name") String name);

    @POST("/addCurrenciesLocale")
    Call<Void> addProduct(@Body CurrencyLocale currencyLocale);


}
