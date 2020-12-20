package Currency.webclient.currency;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class CurrencyUrl {

    private final CurrencyWithIpStack currencyWithIpStack;

    public String getUrl() { return "http://api.currencylayer.com/"; }
    public String getUrlIpStack() throws Exception
    {
        return "https://api.ipstack.com/" + Arrays.toString(currencyWithIpStack.getIpAddress()) + getKey();
    }
    public String getUrlLiveCurrency() { return getUrl() +"live"; }
    public String getUrlDateCurrency() { return getUrl() +"historical"+ getKey()+"/date={date}"; }
    public String getUrlAmountWithSourceCurrency() { return getUrl() + getUrlDateCurrency() + getKey() + "&source={source}" +"&amount={amount}";}
    public String getKey() { return "?access_key=07f5f38393ee1ada9be581377906ffca";}
}
