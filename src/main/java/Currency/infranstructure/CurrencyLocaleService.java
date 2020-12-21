package Currency.infranstructure;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface CurrencyLocaleService {

    @GET("/getCurrenciesLocale")
    Call<List<Currency.domain.service.CurrencyLocaleService>> getCurrencyLocale();

    @GET("/getCurrenciesLocale/{name}")
    Call<List<Currency.domain.service.CurrencyLocaleService>> getCurrencyLocaleByName(@Path("name") String name);

    @POST("/addCurrenciesLocale")
    Call<Void> addProduct(@Body Currency.domain.service.CurrencyLocaleService currencyLocale);


}
