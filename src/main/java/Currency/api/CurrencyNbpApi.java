package Currency.api;

import Currency.domain.service.CurrencyNbp;
import com.sun.jersey.api.client.ClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyNbpApi {

    private final CurrencyNbp currencyNbp;

    @GetMapping("/currencies/{table}")
    ClientResponse getCurrencyBuyingAndSell(@PathVariable char table)
    {
        return currencyNbp.getCurrencyBuyingAndSell(table);
    }
}
