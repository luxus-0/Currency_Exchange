package Currency.api;

import Currency.domain.service.CurrencyLocale;
import Currency.infranstructure.CurrencyLocaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyApiRetrofit {

    private final CurrencyLocaleService currencyLocaleService;

    public Call<List<CurrencyLocale>> getLocaleCurrency()
    {
        return currencyLocaleService.getCurrencyLocale();
    }

    public Call<List<CurrencyLocale>> getLocaleCurrency(String name)
    {
        return currencyLocaleService.getCurrencyLocaleByName(name);
    }
}
