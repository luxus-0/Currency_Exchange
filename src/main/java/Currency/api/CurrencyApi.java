package Currency.api;

import Currency.model.*;
import Currency.webclient.currency.*;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class CurrencyApi {

    private final CurrencyClient currencyClient;
    private final CurrencyScheduled currencyScheduled;
    private final CurrencyDate currencyDate;
    private final CurrencyConvert currencyConvert;
    private final CurrencyDateAndConvert currencyDateAndConvert;
    private final CurrencyTimeFrame currencyTimeFrame;

    @GetMapping("/currencies")
    public void getCurrency() throws Exception {
        currencyScheduled.getCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyScheduled.getCurrencyLive();
    }

    @GetMapping("/currencies/{date}")
    public CurrencyDateDto getCurrencyDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date) throws Exception {
        return currencyDate.getCurrencyDate(date);
    }

    @GetMapping("/currencies/{currencies}/{amount}/{source}")
    public CurrencyDto getCurrencyAmountWithSource(@PathVariable String currencies,@PathVariable Float amount,@PathVariable String source)
    {
        return currencyClient.getCurrencyAmountWithSource(currencies,amount, source);
    }

    @GetMapping("/currencies/{date}/{from}/{to}/{amount}")
    public CurrencyDateAndConvertDto getCurrencyDateWithConvert(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date, @PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyDateAndConvert.getCurrencyDateWithConverter(date, from, to, amount);
    }

    @GetMapping("/currencies/convert/{from}/{to}/{amount}")
    public CurrencyConverterDto getCurrencyConvert(@PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyConvert.convert(from, to, amount);
    }

    @GetMapping("/currencies/timeFrame/{currencies}/{startDate}/{endDate}")
    public CurrencyTimeFrameDto getCurrencyTimeFrame(@PathVariable String currencies, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
        return currencyTimeFrame.getCurrencyTimeFrame(currencies,startDate,endDate);
    }
}
