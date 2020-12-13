package Currency.controller;

import Currency.model.CurrencyDto;
import Currency.service.CurrencyService;
import Currency.webclient.currency.CurrencyClient;
import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyHttpClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyHttpClient currencyHttpClient;
    private final CurrencyConvert currencyConvert;

    private final CurrencyService service;

    @GetMapping("/currencies/v1")
    public CurrencyDto getAllCurrency()
    {
        return service.getCurrency();
    }

    @GetMapping("/currencies/v2")
    public void getCurrency() throws Exception {
        currencyHttpClient.getAllCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyHttpClient.getLiveCurrency();
    }

    @GetMapping("/currencies/date")
    public void getDateCurrency() {
        currencyHttpClient.getDateCurrency();
    }

    @GetMapping("/currencies/{usd}")
    public CurrencyDto getCurrencyUsd(@PathVariable String usd)
    {
        return currencyClient.getCurrencyForUsd(usd);
    }

    @GetMapping("/currencies/{euro}")
    public CurrencyDto getCurrencyEuro(@PathVariable String euro)
    {
        return currencyClient.getCurrencyForEuro(euro);
    }

    @GetMapping("/currencies/{pln}")
    public CurrencyDto getCurrencyPln(@PathVariable String pln)
    {
        return currencyClient.getCurrencyForPln(pln);
    }

    @GetMapping("/currencies/convert/from/{from}/to/{to}/amount/{amount}")
    public void convertFromTo(@PathVariable String from,@PathVariable String to,@PathVariable Float amount) throws Exception {
        currencyConvert.convert(from, to, amount);
    }

}
