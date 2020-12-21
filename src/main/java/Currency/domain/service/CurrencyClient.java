package Currency.domain.service;

import Currency.core.exception.CurrencySourceNotFoundException;
import Currency.domain.model.CurrencyDto;
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
       callUsd(currencyUrl.getUrlAmountWithSourceCurrency(),
                CurrencyDto.class,
                getAccessKey(),currency,amount,source);

       Set<String> currencies = new HashSet<>();
       currencies.add(currency);
       CurrencyDto dto = currencyDtoCreator.create(currencies,amount,source);

       if(!currencies.isEmpty() && !source.isEmpty() && amount > 0) {

           log.info("\nCurrencies: " + currencies+"\nAmount: " +amount + "\nSource: " +source);
       }
       else
       {
           throw new CurrencySourceNotFoundException("Currencies and source and amount not found!!");
       }
       return dto;
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
