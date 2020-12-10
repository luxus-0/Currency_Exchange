package Currency.model;

import Currency.webclient.currency.CurrencyHttpClient;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccessKey {

    private final CurrencyHttpClient client;
    private final String key;

    public String getKey()
    {
        return "access_key=c3a793be6c037bb9b765cbd61037d4a0";
    }


}
