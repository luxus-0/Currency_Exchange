package Currency.webclient.currency;

public class CurrencyUrl {

    private String url;
    private String urlLiveCurrency;
    private String urlDateCurrency;
    private String key;

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
