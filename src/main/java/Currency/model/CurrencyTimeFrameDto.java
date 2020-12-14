package Currency.model;

import Currency.model.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyTimeFrameDto{

    private final Long id;
    private final Set<CurrencyDto> currencies;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public void get()
    {

    }
}
