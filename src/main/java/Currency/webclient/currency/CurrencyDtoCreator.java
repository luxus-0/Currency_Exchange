package Currency.webclient.currency;

import Currency.model.CurrencySourceDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDtoCreator {

    public void createSourceCurrencies(String source,float amount)
    {
        CurrencySourceDto.builder()
                .source(source)
                .amount(amount)
                .build();
    }
}
