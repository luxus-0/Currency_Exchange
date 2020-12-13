package Currency.webclient.currency;

import Currency.exception.CurrencyDateNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
@Log4j2
public class CurrencyDate {

    private final CurrencyUrl url;

    public void getDateCurrency(LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty())
        {
            log.info("Currency date is empty");
        }
        else
        {
            Set<LocalDate> dateCurrency = Set.of(LocalDate.now(),LocalDate.of(2020,11,7));
            JSONObject currencyDate = new JSONObject(url.getUrlDateCurrency().indexOf(0));
            dateCurrency.stream().filter(p -> p.getYear() == 2020).findAny().orElseThrow(() -> new CurrencyDateNotFoundException("currency actual date not found!!"));
            log.info(currencyDate);
        }

    }
}
