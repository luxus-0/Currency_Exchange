package Currency.api;

import Currency.domain.service.CurrencyLocaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyApiRetrofit {

    private final Currency.infranstructure.CurrencyLocaleService currencyLocaleService;

    public Call<List<CurrencyLocaleService>> getLocaleCurrency()
    {
        return currencyLocaleService.getCurrencyLocale();
    }

    public Call<List<CurrencyLocaleService>> getLocaleCurrency(String name)
    {
        return currencyLocaleService.getCurrencyLocaleByName(name);
    }

    public Call<Void> addCurrencyLocale(CurrencyLocaleService currencyLocale)
    {
        return currencyLocaleService.addProduct(currencyLocale);
    }
}
