package Currency.model;

import Currency.model.CurrencyDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Set;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyTimeFrameDto{
    @Id
    private Long id;
    private Set<String> currenciesTimeFrame;
    private LocalDate startDate;
    private LocalDate endDate;
}
