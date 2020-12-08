package Currency.webclient.currency;

import Currency.model.CurrencyDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CURRENCY_URL = "http://api.currencylayer.com/";
    private static final String ACCESS_KEY = "c3a793be6c037bb9b765cbd61037d4a0";

    public CurrencyDto getCurrencyForUsd(String usd)
    {
       CurrencyDto currencyDto =  callUsd("live?access_key={accessKey}&format=1&source={source}",
                CurrencyDto.class,
                ACCESS_KEY,usd);

        return CurrencyDto.builder()
                .pln(currencyDto.getPln())
                .usd(currencyDto.getUsd())
                .euro(currencyDto.getEuro())
                .build();
    }

    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        return restTemplate.getForObject(CURRENCY_URL + url
                , reponseType, objects);
    }


}
