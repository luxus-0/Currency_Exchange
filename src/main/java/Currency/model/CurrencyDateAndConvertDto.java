package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class CurrencyDateAndConvertDto {
    private final Set<CurrencyConverterDto> currencyConverterDto;
    private final Set<LocalDate> currencyDateDto;
}
