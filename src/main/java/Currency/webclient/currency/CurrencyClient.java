package Currency.webclient.currency;

import Currency.exception.SourceCurrencyNotFoundException;
import Currency.model.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Log4j2
@AllArgsConstructor
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final CurrencyUrl currencyUrl;
    private final CurrencyDtoCreator builderCurrency;

    public CurrencyDto getSourceCurrency(String source,Float amount)
    {
       CurrencyDto currencyDto =  callUsd(currencyUrl.getUrlSourceAndAmountCurrency(),
                CurrencyDto.class,
                getAccessKey(),source,amount);

       builderCurrency.createSourceCurrencies(source,amount);
       if(source.equals("") && amount > 0) {

           log.info("All Currencies: " +currencyDto.getCurrencies() + "\nAmount: " +amount);
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
