package Currency.webclient.currency;

import Currency.model.CurrencyDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Log4j2
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CURRENCY_URL = "http://api.currencylayer.com/";
    private static final String ACCESS_KEY = "c3a793be6c037bb9b765cbd61037d4a0";

    public CurrencyDto getCurrencyForUsd(String usd)
    {
       CurrencyDto currencyDto =  callUsd("live?access_key={accessKey}&format=1&source={source}",
                CurrencyDto.class,
                ACCESS_KEY,usd);

        return buildCurrencyUsd(currencyDto);
    }

    public CurrencyDto getCurrencyForPln(String pln) {
        CurrencyDto currencyPlnDto =  callUsd("live?access_key={accessKey}&format=1&source={source}",
                CurrencyDto.class,
                ACCESS_KEY,pln);

        return buildCurrencyPln(currencyPlnDto);
    }

    public CurrencyDto getCurrencyForEuro(String euro) {
        CurrencyDto currencyEuroDto =  callUsd("live?access_key={accessKey}&format=1&source={source}",
                CurrencyDto.class,
                ACCESS_KEY,euro);

        return buildCurrencyEuro(currencyEuroDto);
    }

    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        return restTemplate.getForObject(CURRENCY_URL + url
                , reponseType, objects);
    }
    public CurrencyDto buildCurrencyPln(CurrencyDto currencyPlnDto)
    {
        return CurrencyDto.builder()
                .usd(currencyPlnDto.getPln())
                .build();
    }

    public CurrencyDto buildCurrencyEuro(CurrencyDto currencyEuroDto)
    {
        return CurrencyDto.builder()
                .usd(currencyEuroDto.getEuro())
                .build();
    }

    public CurrencyDto buildCurrencyUsd(CurrencyDto currencyUsdDto)
    {
       return CurrencyDto.builder()
                .usd(currencyUsdDto.getUsd())
                .build();
    }
}
