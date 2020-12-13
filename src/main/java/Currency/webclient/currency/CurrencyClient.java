package Currency.webclient.currency;

import Currency.builder.CurrencyBuilder;
import Currency.model.CurrencyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Log4j2
@RequiredArgsConstructor
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final CurrencyBuilder creator = new CurrencyBuilder();
    private static final String CURRENCY_URL = "http://api.currencylayer.com/";
    private static final String ACCESS_KEY = "c3a793be6c037bb9b765cbd61037d4a0";

    public CurrencyDto getSourceCurrency(String source)
    {
       CurrencyDto currencyDto =  callUsd("live?access_key={accessKey}&format=1&source={source}",
                CurrencyDto.class,
                ACCESS_KEY,source);

        creator.buildCurrencyUsd(currencyDto);
        creator.buildCurrencyEuro(currencyDto);
        creator.buildCurrencyPln(currencyDto);

        return currencyDto;
    }



    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        return restTemplate.getForObject(CURRENCY_URL + url
                , reponseType, objects);
    }

}
