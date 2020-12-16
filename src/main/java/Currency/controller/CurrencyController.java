package Currency.controller;

import Currency.model.CurrencyConverterDto;
import Currency.model.CurrencyDateAndConvertDto;
import Currency.model.CurrencyDto;
import Currency.webclient.currency.*;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyScheduled currencyScheduled;
    private final CurrencyDate currencyDate;
    private final CurrencyConvert currencyConvert;
    private final CurrencyDateAndConvert currencyDateAndConvert;

    @GetMapping("/currencies")
    public void getCurrency() throws Exception {
        currencyScheduled.getCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyScheduled.getCurrencyLive();
    }

    @GetMapping("/currencies/{date}")
    public LocalDate getCurrencyDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date) throws Exception {
        return currencyDate.getCurrencyDate(date);
    }

    @GetMapping("/currencies/{amount}/{source}")
    public CurrencyDto getCurrencyAmountWithSource(@PathVariable Float amount,@PathVariable String source)
    {
        return currencyClient.getCurrencyAmountWithSource(amount, source);
    }

    @GetMapping("/currencies/{date}/{from}/{to}/{amount}")
    public CurrencyDateAndConvertDto getCurrencyDateWithConvert(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date, @PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyDateAndConvert.getCurrencyDateWithConverter(date, from, to, amount);
    }

    @GetMapping("/currencies/convert/{from}/{to}/{amount}")
    public CurrencyConverterDto getCurrencyConvert(@PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyConvert.convert(from, to, amount);
    }

}
