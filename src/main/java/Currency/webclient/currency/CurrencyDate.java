package Currency.webclient.currency;

import Currency.exception.CurrencyDateNotFoundException;
import Currency.exception.DateCurrencyException;
import Currency.model.CurrencyConverterDto;
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

    public CurrencyDateDto getDateCurrency(LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty() && date == null)
        {
            throw new DateCurrencyException("Currency date is empty");
        }
        else
        {
            getDate();
            JSONObject currencyDate = new JSONObject(url.getUrlDateCurrency().indexOf(0));
            JSONObject currencyDate2 = new JSONObject(url.getUrlDateCurrency().indexOf(1));
            JSONObject currencyDate3 = new JSONObject(url.getUrlDateCurrency().indexOf(2));
            log.info(currencyDate);
            log.info(currencyDate2);
            log.info(currencyDate3);
        }

        return dateDto;
    }

    public void getDate()
    {
        Set<LocalDate> dateCurrency = Set.of(LocalDate.now(),LocalDate.of(2020,11,7));
        CurrencyConverterDto convert = new CurrencyConverterDto(1L,"USD","EUR",12);
        CurrencyDateDto dateDto = CurrencyDateDto.builder().currencyDate(dateCurrency).converterDto(convert).build();
        dateCurrency.stream().filter(p -> p.getYear() == 2020).findAny().orElseThrow(() -> new CurrencyDateNotFoundException("currency actual date not found!!"));
        log.info(dateDto.getCurrencyDate());
    }
}
