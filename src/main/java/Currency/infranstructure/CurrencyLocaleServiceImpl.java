package Currency.infranstructure;

import Currency.core.validation.CurrencyLocaleValid;
import Currency.domain.client.RetrofitClient;
import Currency.domain.model.entity.CurrencyLocale;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyLocaleServiceImpl {

    private RetrofitClient client;
    private CurrencyLocaleValid currencyLocaleValid;

    public Response<List<CurrencyLocaleService>> getCurrencyLocale() throws Exception {
        CurrencyLocaleService service = client.getRetrofitClient().create(CurrencyLocaleService.class);
        Response<List<CurrencyLocaleService>> response = service.getCurrencyLocale().execute();
        List<CurrencyLocaleService> currencies = response.body();
        currencyLocaleValid.valid(currencies);


        return Response.success(currencies);
    }

    public Response<List<CurrencyLocaleService>> getCurrencyLocaleByName(String name) throws Exception {
        CurrencyLocaleService service = client.getRetrofitClient().create(CurrencyLocaleService.class);
        Response<List<CurrencyLocaleService>> response = service.getCurrencyLocaleByName(name).execute();
        List<CurrencyLocaleService> currencies = response.body();
        currencyLocaleValid.valid(currencies);

        return Response.success(currencies);
    }

    public void addCurrencyLocale(CurrencyLocale currencyLocale) throws Exception {
        CurrencyLocaleService service = client.getRetrofitClient().create(CurrencyLocaleService.class);
        service.addCurrencyLocale(new CurrencyLocale(1L, "USD")).execute();
    }


}
