package Currency.validation;

import Currency.exception.CurrencyTimeFrameNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Log4j2
public class CurrencyTimeFrameValid {

    public void valid(LocalDate startDate,LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            log.info("start date is after than endDate");
        } else {
            throw new CurrencyTimeFrameNotFoundException("Currency time frame not found!!");
        }
    }
}
