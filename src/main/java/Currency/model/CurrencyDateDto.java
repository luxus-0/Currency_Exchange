package Currency.model;

import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyConverterCreator;
import Currency.webclient.currency.CurrencyDateCreator;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class CurrencyDateDto {

    private final Set<LocalDate> currenciesDateDto;
    private final Set<CurrencyConverterDto> currenciesConverterDto;
    private final CurrencyConvert currencyConvert;
    private final CurrencyDateCreator dateCreator;
    private final CurrencyConverterCreator converterCreator;

    @Builder
    public CurrencyDateDto(Set<LocalDate> currenciesDateDto, Set<CurrencyConverterDto> currenciesConverterDto, CurrencyConvert currencyConvert, CurrencyDateCreator dateCreator, CurrencyConverterCreator converterCreator) {
        this.currenciesDateDto = currenciesDateDto;
        this.currenciesConverterDto = currenciesConverterDto;
        this.currencyConvert = currencyConvert;
        this.dateCreator = dateCreator;
        this.converterCreator = converterCreator;
    }
}
