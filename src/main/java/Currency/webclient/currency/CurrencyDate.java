package Currency.webclient.currency;

import Currency.exception.DateCurrencyException;
import Currency.model.CurrencyDateDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyDate {

    private final CurrencyUrl url;
    private final CurrencyDateDto dateDto;

    public Set<LocalDate> getCurrencyDate(LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty() && date == null)
        {
            throw new DateCurrencyException("Currency date is empty");
        }
        else
        {
            for(int i = 0; i < 4;i++) {
                JSONObject currencyDate = new JSONObject(url.getUrlDateCurrency().indexOf(i));
                log.info(currencyDate);
            }


        }

        return dateDto.get();
    }


}
