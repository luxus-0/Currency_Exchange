package Currency.webclient.currency;

import Currency.model.CurrencyTimeFrameDto;
import Currency.validation.CurrencyTimeFrameValid;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@AllArgsConstructor
public class CurrencyTimeFrame {

    private final CurrencyTimeFrameCreator creator;
    private final CurrencyTimeFrameValid currencyTimeFrameValid;
    private final JdbcTemplate jdbcTemplate;
    private final CurrencyTimeFrameDto currencyTimeFrameDto;

    public CurrencyTimeFrameDto getCurrencyTimeFrame(String currencies, LocalDate startDate, LocalDate endDate)
    {
        currencyTimeFrameValid.valid(startDate, endDate);
        Set<String> currenciesTimeFrame = Set.of(currencies);
        creator.createCurrencyTimeFrame(startDate,endDate);

        return currencyTimeFrameDto;
    }
}
