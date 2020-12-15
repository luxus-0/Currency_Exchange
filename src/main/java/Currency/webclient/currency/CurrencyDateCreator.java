package Currency.webclient.currency;

import Currency.model.CurrencyDateDto;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
public class CurrencyDateCreator {

    public CurrencyDateDto create(Set<LocalDate> currencyDateDto)
    {
        return CurrencyDateDto.builder()
                .currenciesDateDto(currencyDateDto)
                .build();

    }
}
