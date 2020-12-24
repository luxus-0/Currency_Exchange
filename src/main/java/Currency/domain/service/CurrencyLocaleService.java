package Currency.domain.service;

import Currency.domain.model.entity.CurrencyLocale;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import java.util.List;

@Component
public interface CurrencyLocaleService {

    Call<List<CurrencyLocaleService>> getCurrencyLocale();
    Call<List<CurrencyLocaleService>> getCurrencyLocaleByName(String name);
    Call<Void> addCurrencyLocale(CurrencyLocale currencyLocale);
}
