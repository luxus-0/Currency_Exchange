package Currency.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CurrencyDateDto {

    private Set<LocalDate> currencyDate;
    private CurrencyConverterDto converterDto;
}
