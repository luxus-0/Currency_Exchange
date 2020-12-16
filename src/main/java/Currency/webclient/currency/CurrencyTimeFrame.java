package Currency.webclient.currency;

import Currency.model.CurrencyTimeFrameDto;
import Currency.validation.CurrencyTimeFrameValid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
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
        String sql = "SELECT * FROM CurrencyTimeFrameDto";
        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CurrencyTimeFrameDto.class));
        log.info(sql);
        log.info(currenciesTimeFrame);

        return currencyTimeFrameDto;
    }
}
