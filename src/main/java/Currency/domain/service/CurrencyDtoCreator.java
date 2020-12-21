package Currency.domain.service;

import Currency.domain.model.dto.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CurrencyDtoCreator {

    public CurrencyDto create(Set<String> currencies, Float amount, String source)
    {
        return CurrencyDto.builder()
                .amount(amount)
                .source(source)
                .build();
    }

}
