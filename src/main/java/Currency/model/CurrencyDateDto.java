package Currency.model;

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
public class CurrencyDateDto {

    private final Set<LocalDate> currenciesDateDto;
    private final Set<CurrencyConverterDto> currenciesConverterDto;
    private final CurrencyConvert currencyConvert;
    private final CurrencyDateCreator dateCreator;
    private final CurrencyConverterCreator converterCreator;



}
