package Currency.controller;

import Currency.model.CurrencyConverterDto;
import Currency.model.CurrencyDto;
import Currency.service.CurrencyService;
import Currency.webclient.currency.CurrencyClient;
import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyDate;
import Currency.webclient.currency.CurrencyScheduled;
import lombok.AllArgsConstructor;
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
    private final CurrencyConvert currency;
    private final CurrencyService service;

    @GetMapping("/currencies/v1")
    public CurrencyDto getAllCurrency()
    {
        return service.getCurrency();
    }

    @GetMapping("/currencies/v2")
    public void getCurrency() throws Exception {
        currencyScheduled.getAllCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyScheduled.getLiveCurrency();
    }

    @GetMapping("/currencies/usd/{usd}")
    public CurrencyDto getCurrencyUsd(@PathVariable String usd)
    {
        return currencyClient.getCurrencyForUsd(usd);
    }

    @GetMapping("/currencies/euro/{euro}")
    public CurrencyDto getCurrencyEuro(@PathVariable String euro)
    {
        return currencyClient.getCurrencyForEuro(euro);
    }

    @GetMapping("/currencies/pln/{pln}")
    public CurrencyDto getCurrencyPln(@PathVariable String pln)
    {
        return currencyClient.getCurrencyForPln(pln);
    }

    @GetMapping("/currencies/date/{date}")
    public void getCurrencyDate(@PathVariable LocalDate date)
    {
        currencyDate.getDateCurrency(date);
    }

    @GetMapping("/currencies/convert/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConverterDto convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currency.convert(from, to, amount);
    }

}
