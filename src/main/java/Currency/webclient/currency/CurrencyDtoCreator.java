package Currency.webclient.currency;

import Currency.model.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CurrencyDtoCreator {

    public CurrencyDto create(Set<String> currency, Float amount, String source)
    {
        return CurrencyDto.builder()
                .amount(amount)
                .source(source)
                .build();
    }
}
