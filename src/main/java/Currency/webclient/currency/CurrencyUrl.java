package Currency.webclient.currency;

import lombok.Getter;


@Getter
public class CurrencyUrl {

    public String getUrl()
    {
        return "http://api.currencylayer.com/";
    }
    public String getUrlLiveCurrency()
    {
        return getUrl() +"live?";
    }
    public String getUrlDateCurrency()
    {
        return getUrl() +"historical"+ getKey()+"/date={date}";
    }
    public String getKey()
    {
        return "?access_key=07f5f38393ee1ada9be581377906ffca";
    }
}
