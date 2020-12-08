package Currency.controller;

import Currency.model.CurrencyDto;
import Currency.service.CurrencyService;
import Currency.webclient.currency.CurrencyClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyService service;

    @GetMapping("/currencies")
    public CurrencyDto getCurrency()
    {
        return service.getCurrency();
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


}
