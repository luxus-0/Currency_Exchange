package Currency.controller;

import Currency.model.CurrencyConverterDto;
import Currency.model.CurrencyDateDto;
import Currency.model.CurrencyDto;
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

    @GetMapping("/currencies")
    public void getCurrency() throws Exception {
        currencyScheduled.getCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyScheduled.getCurrencyLive();
    }

    @GetMapping("/currencies/amount={amount}/source={source}")
    public CurrencyDto getCurrencySource(@PathVariable Float amount,@PathVariable String source)
    {
        return currencyClient.getCurrencyAmountWithSource(amount, source);
    }

    @GetMapping("/currencies/date/{date}/from/{from}/to/{to}/amount/{amount}")
    public CurrencyDateDto getCurrencyDateWithConvert(@PathVariable LocalDate date,@PathVariable String from,@PathVariable String to,@PathVariable Float amount)
    {
        return currencyDate.getCurrencyDate(date);
    }

    @GetMapping("/currencies/convert/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConverterDto getCurrencyConvert(@PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currency.convert(from, to, amount);
    }

}
