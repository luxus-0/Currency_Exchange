package Currency.webclient.currency;

import Currency.exception.CurrencySourceNotFoundException;
import Currency.model.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
@Log4j2
@AllArgsConstructor
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final CurrencyUrl currencyUrl;
    private final CurrencyDtoCreator currencyDtoCreator;

    public CurrencyDto getCurrencyAmountWithSource(String currency,Float amount, String source)
    {
       CurrencyDto currencyDto =  callUsd(currencyUrl.getUrlAmountWithSourceCurrency(),
                CurrencyDto.class,
                getAccessKey(),currency,amount,source);

       Set<String> currencies = new HashSet<>();
       currencies.add(currency);
       currencyDtoCreator.create(currencies,amount,source);

       if(!source.isEmpty() && amount > 0) {

           log.info("Amount: " +amount + " Source: " +source);
       }
       else
       {
           throw new CurrencySourceNotFoundException("Source Currency Not Found");
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
