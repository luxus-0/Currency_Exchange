package Currency.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDateDto {

    private Set<LocalDate> currencyDate;
    private CurrencyConverterDto converterDto;
}
