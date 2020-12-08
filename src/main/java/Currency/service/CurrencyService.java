package Currency.service;

import Currency.model.CurrencyDto;
import Currency.webclient.currency.CurrencyClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public CurrencyDto getCurrency()
    {
        String response = currencyClient.getCurrencyForUsd("USD");
        log.info(response);
        return null;
    }

}
