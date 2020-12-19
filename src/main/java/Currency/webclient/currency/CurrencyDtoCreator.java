package Currency.webclient.currency;

import Currency.model.CurrencyDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDtoCreator {

    public CurrencyDto create(Float amount, String source)
    {
        return CurrencyDto.builder()
                .amount(amount)
                .source(source)
                .build();
    }

}
