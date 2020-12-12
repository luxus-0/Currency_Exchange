package Currency.controller;

import Currency.model.CurrencyDto;
import Currency.service.CurrencyService;
import Currency.webclient.currency.CurrencyClient;
import Currency.webclient.currency.CurrencyHttpClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyHttpClient currencyHttpClient;
    private final CurrencyService service;

    @GetMapping("/currencies/v1")
    public CurrencyDto getAllCurrency()
    {
        return service.getCurrency();
    }

    @GetMapping("/currencies/v2")
    public void getCurrency() throws IOException, InterruptedException {
        currencyHttpClient.getAllCurrency();
    }

    @GetMapping("/currencies/base")
    public void getLiveCurrency() throws IOException, InterruptedException {
        currencyHttpClient.getBaseCurrency();
    }

    @GetMapping("/currencies/date")
    public void getDateCurrency() throws JsonProcessingException {
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

    @GetMapping("/currencies/convert/euro/gbp")
    public void convertFromEuroToGbp() throws IOException, InterruptedException {
        currencyHttpClient.convertFromEuroToGbp();
    }

    @GetMapping("/currencies/convert/euro/pln")
    public void convertFromEuroToPln(@PathVariable String amount) throws IOException, InterruptedException {
        currencyHttpClient.convertFromEuroToPln(amount);
    }

}
