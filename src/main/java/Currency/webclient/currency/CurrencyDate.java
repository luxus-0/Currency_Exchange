package Currency.webclient.currency;

import Currency.exception.CurrencyDateNotFoundException;
import Currency.model.CurrencyConverterDto;
import Currency.model.CurrencyDateDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@NoArgsConstructor
@Log4j2
public class CurrencyDate {

    private CurrencyUrl url;
    private CurrencyDateDto dateDto;

    public CurrencyDateDto getDateCurrency(LocalDate date) {
        if(url.getUrlDateCurrency().isEmpty())
        {
            log.info("Currency date is empty");
        }
        else
        {
            getDate();
            JSONObject currencyDate = new JSONObject(url.getUrlDateCurrency().indexOf(0));
            log.info(currencyDate);

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
