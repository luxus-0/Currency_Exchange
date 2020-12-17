package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
public class CurrencyTimeFrameDto{

    private final Long id;
    private final Set<String> currenciesTimeFrame;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
