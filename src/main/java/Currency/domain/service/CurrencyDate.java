package Currency.domain.service;

import Currency.core.exception.CurrencyDateNotFoundException;
import Currency.domain.model.dto.CurrencyDateDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyDate {

    private final CurrencyUrl url;
    private final CurrencyDateCreator currencyDateCreator;

    public CurrencyDateDto getCurrencyDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty() && date == null)
        {
            throw new CurrencyDateNotFoundException("Currency date is empty");
        }
        else
        {
            JSONObject currencyDate = new JSONObject(date);
            CurrencyDateDto currencyDateDto = currencyDateCreator.create(Set.of(date));
            log.info(currencyDate);
            log.info(currencyDateDto);
            return currencyDateDto;
        }
    }
}
