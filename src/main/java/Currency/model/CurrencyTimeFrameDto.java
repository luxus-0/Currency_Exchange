package Currency.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class CurrencyTimeFrameDto{

    private final Long id;
    private final Set<String> currenciesTimeFrame;
    private final LocalDate startDate;
    private final LocalDate endDate;

    @Builder
    public CurrencyTimeFrameDto(Long id, Set<String> currenciesTimeFrame, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.currenciesTimeFrame = currenciesTimeFrame;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
