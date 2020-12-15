package Currency.webclient.currency;

import Currency.exception.SourceCurrencyNotFoundException;
import Currency.model.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@AllArgsConstructor
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final CurrencyUrl currencyUrl;

    public CurrencyDto getCurrencyAmountWithSource(Float amount, String source)
    {
       CurrencyDto currencyDto =  callUsd(currencyUrl.getUrlSourceAndAmountCurrency(),
                CurrencyDto.class,
                getAccessKey(),amount,source);

       CurrencyDto currency = new CurrencyDto();
       currency.setAmount(amount);
       currency.setSource(source);

       if(source.equals(currency.getSource()) && amount > 0) {

           log.info("Amount: " +amount + " Source: " +source);
       }
       else
       {
           throw new SourceCurrencyNotFoundException("Source Currency Not Found");
       }
       return currencyDto;
    }

    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        return restTemplate.getForObject(currencyUrl.getUrl() + url, reponseType, objects);
    }

    public String getAccessKey()
    {
         return "c3a793be6c037bb9b765cbd61037d4a0";
    }

}
