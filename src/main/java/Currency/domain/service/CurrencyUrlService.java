package Currency.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CurrencyUrlService {

    private final CurrencyWithIpStackService currencyWithIpStackService;

    public String getUrl() { return "http://api.currencylayer.com/"; }
    public String showUrlIpStack() throws Exception
    {
        return "https://api.ipstack.com/" + currencyWithIpStackService.showIpAddress() + getKey();
    }
    public String getUrlIpStack(String address)
    {
        return "https://api.ipstack.com/" + address + getKey();
    }
    public String getUrlNbp(char table){return "http://api.nbp.pl/api/exchangerates/tables/" +table;}
    public String getUrlLiveCurrency() { return getUrl() +"live"; }
    public String getUrlDateCurrency() { return getUrl() +"historical"+ getKey()+"/date={date}"; }
    public String getUrlAmountWithSourceCurrency() { return getUrl() + getUrlDateCurrency() + getKey() + "&source={source}" +"&amount={amount}";}
    public String getKey() { return "?access_key=07f5f38393ee1ada9be581377906ffca";}
}
