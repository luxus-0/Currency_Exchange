package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
public class CurrencyDateAndConvertDto {
    private final Set<CurrencyConverterDto> currencyConverterDto;
    private final Set<LocalDate> currencyDateDto;
}
