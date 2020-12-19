package Currency.model;

import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyConverterCreator;
import Currency.webclient.currency.CurrencyDateCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDateDto {

    private Set<LocalDate> currenciesDateDto;
    private Set<CurrencyConverterDto> currenciesConverterDto;
    private CurrencyConvert currencyConvert;
    private CurrencyDateCreator dateCreator;
    private CurrencyConverterCreator converterCreator;
}
