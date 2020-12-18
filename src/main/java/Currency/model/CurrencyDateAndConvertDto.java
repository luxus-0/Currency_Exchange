package Currency.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class CurrencyDateAndConvertDto {
    private final Set<CurrencyConverterDto> currencyConverterDto;
    private final Set<LocalDate> currencyDateDto;

    @Builder
    public CurrencyDateAndConvertDto(Set<CurrencyConverterDto> currencyConverterDto, Set<LocalDate> currencyDateDto) {
        this.currencyConverterDto = currencyConverterDto;
        this.currencyDateDto = currencyDateDto;
    }
}
