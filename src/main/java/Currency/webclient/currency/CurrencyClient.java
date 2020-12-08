package Currency.webclient.currency;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyClient {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String CURRENCY_URL = "http://api.currencylayer.com/";
    private static final String ACCESS_KEY = "c3a793be6c037bb9b765cbd61037d4a0";

    public String getCurrencyForUsd(String usd)
    {
        return callUsd("live?access_key={accessKey}&format=1&source={source}",
                String.class,
                ACCESS_KEY,usd);
    }

    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        return restTemplate.getForObject(CURRENCY_URL + url
                , reponseType, objects);
    }


}
