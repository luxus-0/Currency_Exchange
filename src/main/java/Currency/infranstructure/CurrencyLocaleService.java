package Currency.infranstructure;


import Currency.domain.model.entity.CurrencyLocale;
import retrofit2.Call;

import java.util.List;

public interface CurrencyLocaleService {

    Call<List<CurrencyLocaleService>> getCurrencyLocale();
    Call<List<CurrencyLocaleService>> getCurrencyLocaleByName(String name);
    Call<Void> addProduct(CurrencyLocale currencyLocale);


}
