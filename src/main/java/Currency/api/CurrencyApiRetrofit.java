package Currency.api;

import Currency.domain.model.entity.CurrencyLocale;
import Currency.infranstructure.CurrencyLocaleService;
import Currency.infranstructure.CurrencyLocaleServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyApiRetrofit {

    private CurrencyLocaleServiceImpl currencyLocaleService;

    @GET("/getCurrenciesLocale")
    public Response<List<CurrencyLocaleService>> getCurrenciesLocale() throws Exception {
        return currencyLocaleService.getCurrencyLocale();
    }

    @GET("/getCurrenciesLocale/{name}")
    public Response<List<CurrencyLocaleService>> getCurrenciesLocaleByName(@Path("name") String name) throws Exception {
        return currencyLocaleService.getCurrencyLocaleByName(name);
    }

    @POST("/addCurrenciesLocale")
    public void addCurrenciesLocale(@Body CurrencyLocale currencyLocale) throws Exception {
        currencyLocaleService.addCurrencyLocale(currencyLocale);
    }
}
