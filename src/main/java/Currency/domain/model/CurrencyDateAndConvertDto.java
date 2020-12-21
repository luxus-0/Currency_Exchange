package Currency.domain.model;

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
public class CurrencyDateAndConvertDto {
    private Set<CurrencyConverterDto> currencyConverterDto;
    private Set<LocalDate> currencyDateDto;

}
