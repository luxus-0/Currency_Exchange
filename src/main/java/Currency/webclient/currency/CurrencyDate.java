package Currency.webclient.currency;

import Currency.exception.CurrencyDateNotFoundException;
import Currency.model.CurrencyDateDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyDate {

    private final CurrencyUrl url;

    public LocalDate getCurrencyDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty() && date == null)
        {
            throw new CurrencyDateNotFoundException("Currency date is empty");
        }
        else
        {
            JSONObject currencyDate = new JSONObject(date);
            log.info(currencyDate);
        }
        return date;
    }
}
