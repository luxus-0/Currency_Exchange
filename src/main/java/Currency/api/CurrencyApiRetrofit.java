package Currency.api;

import Currency.domain.model.entity.CurrencyLocale;
import Currency.infranstructure.CurrencyLocaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyApiRetrofit {

    private final CurrencyLocaleService currencyLocaleService;

    @GET("/getCurrenciesLocale")
    public Call<List<CurrencyLocaleService>> getCurrenciesLocale() {
        return currencyLocaleService.getCurrencyLocale();
    }

    @GET("/getCurrenciesLocale/{name}")
    public Call<List<CurrencyLocaleService>> getCurrenciesLocaleByName(@Path("name") String name) {
        return currencyLocaleService.getCurrencyLocaleByName(name);
    }

    @POST("/addCurrenciesLocale")
    public Call<Void> addCurrenciesLocale(@Body CurrencyLocale currencyLocale) {
        return currencyLocaleService.addProduct(currencyLocale);
    }
}
