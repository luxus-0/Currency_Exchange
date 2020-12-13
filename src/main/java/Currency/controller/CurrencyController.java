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
    private final CurrencyConvert convert;

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

    @GetMapping("/currencies/base")
    public void getLiveCurrency() throws Exception {
        currencyHttpClient.getBaseCurrency();
    }

    @GetMapping("/currencies/date")
    public void getDateCurrency() {
        currencyHttpClient.getDateCurrency();
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

    @GetMapping("/currencies/convert/euro/gbp/amount={amount}")
    public void convertFromEuroToGbp(@PathVariable Float amount) throws Exception {
        convert.fromEuroToGbp(amount);
    }

    @GetMapping("/currencies/convert/euro/pln/amount={amount}")
    public void convertFromEuroToPln(@PathVariable Float amount) throws Exception {
        convert.fromEuroToPln(amount);
    }

}
