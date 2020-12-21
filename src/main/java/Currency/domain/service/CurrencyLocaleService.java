package Currency.domain.service;

import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Service
public class CurrencyLocaleService {

    public List<Currency> getLocaleCurrency()
    {
        List<Currency> currencies = List.of(Currency.getInstance(Locale.UK));

        for(int i = 0; i < currencies.size(); i++) {
            if (currencies.get(i).toString().equals("")) {
                currencies.stream()
                        .filter(p -> p.getSymbol().length() > 0)
                        .forEach(System.out::println);
            }
            else if(currencies.get(i).toString().isEmpty())
            {
                currencies.stream().filter((p) ->
                {
                    throw new RuntimeException("Currency Locale is empty");
                }).forEach(System.out::println);
            }
        }
        return currencies;
    }
}
