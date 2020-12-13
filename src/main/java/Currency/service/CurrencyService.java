package Currency.service;

import Currency.model.CurrencyDto;
import Currency.webclient.currency.CurrencyClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public CurrencyDto getUsd()
    {
        return currencyClient.getCurrencyForUsd("Usd");
    }

    public CurrencyDto getPln()
    {
        return currencyClient.getCurrencyForPln("Pln");
    }

    public CurrencyDto getEur()
    {
        return currencyClient.getCurrencyForEuro("Euro");
    }
}
