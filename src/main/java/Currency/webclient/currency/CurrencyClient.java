package Currency.webclient.currency;

import Currency.exception.CurrencySourceNotFoundException;
import Currency.model.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyClient {

    private final CurrencyUrl currencyUrl;
    private final CurrencyDtoCreator currencyDtoCreator;

    public CurrencyDto getCurrencyAmountWithSource(String currency, Float amount, String source)
    {
       CurrencyDto currencyDto =  callUsd(currencyUrl.getUrlAmountWithSourceCurrency(),
                CurrencyDto.class,
                getAccessKey(),currency,amount,source);

       Set<String> currencies = new HashSet<>();
       currencies.add(currency);
       currencyDtoCreator.create(amount,source);

       if(!currencies.isEmpty() && !source.isEmpty() && amount > 0) {

           log.info("Currencies: " + currencies+"\nAmount: " +amount + "\nSource: " +source);
       }
       else
       {
           throw new CurrencySourceNotFoundException("Currencies and source and amount not found!!");
       }
       return currencyDto;
    }

    public <T> T callUsd(String url, Class<T> reponseType, Object...objects) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(currencyUrl.getUrl() + url, reponseType, objects);
    }

    public String getAccessKey()
    {
         return "c3a793be6c037bb9b765cbd61037d4a0";
    }

}
