package Currency.domain.service;

import Currency.domain.model.CurrencyDateDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class CurrencyDateCreator {

    public CurrencyDateDto create(Set<LocalDate> currencyDateDto)
    {
        return CurrencyDateDto.builder()
                .currenciesDateDto(currencyDateDto)
                .build();
    }
}
