package Currency.webclient.currency;

import org.springframework.stereotype.Component;

@Component
public class CurrencyUrl {

    public String getUrl() { return "http://api.currencylayer.com/"; }
    public String getUrlLiveCurrency() { return getUrl() +"live"; }
    public String getUrlDateCurrency() { return getUrl() +"historical"+ getKey()+"/date={date}"; }
    public String getUrlAmountWithSourceCurrency() { return getUrl() + getUrlDateCurrency() + getKey() + "&source={source}" +"&amount={amount}";}
    public String getKey() { return "?access_key=07f5f38393ee1ada9be581377906ffca";}
}
