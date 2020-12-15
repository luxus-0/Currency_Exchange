package Currency.model;

import Currency.exception.CurrencyConvertNotFoundException;
import Currency.exception.CurrencyDateNotFoundException;
import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyConverterCreator;
import Currency.webclient.currency.CurrencyDateCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Log4j2
public class CurrencyDateDto {

    private Set<LocalDate> currenciesDateDto;
    private Set<CurrencyConverterDto> currenciesConverterDto;
    private CurrencyConvert currencyConvert;
    private CurrencyDateCreator dateCreator;
    private CurrencyConverterCreator converterCreator;

}
