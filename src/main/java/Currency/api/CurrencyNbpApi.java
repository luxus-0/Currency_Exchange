package Currency.api;

import Currency.domain.service.CurrencyNbp;
import Currency.domain.service.CurrencyNbpDate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyNbpApi {

    private final CurrencyNbp currencyNbp;
    private final CurrencyNbpDate currencyNbpDate;

    @GetMapping("/currencies/nbp/{table}")
    public String getCurrencyBuyingAndSell(@PathVariable char table)
    {
        return currencyNbp.getCurrencyBuyingAndSell(table);
    }

    @GetMapping("/currencies/nbp/{table}/today")
    public String getCurrencyDateByToday(@PathVariable char table)
    {
        return currencyNbpDate.getCurrencyToday(table);
    }
}
