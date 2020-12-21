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
public class CurrencyDateDto {
    private Set<LocalDate> currenciesDateDto;
}
