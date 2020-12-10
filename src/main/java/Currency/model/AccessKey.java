package Currency.model;

import Currency.webclient.currency.CurrencyHttpClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccessKey {

    private final CurrencyHttpClient client;
    private final String key;

    public String getKey()
    {
        return "access_key=c3a793be6c037bb9b765cbd61037d4a0";
    }

    public String getUrlKey()
    {
        return client.getUrl()+getKey();
    }

}
