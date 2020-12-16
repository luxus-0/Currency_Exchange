package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@AllArgsConstructor
@Getter
public class CurrencyDateAndConvertDto {
    private final Set<CurrencyConverterDto> currencyConverterDto;
    private final Set<LocalDate> currencyDateDto;
}
