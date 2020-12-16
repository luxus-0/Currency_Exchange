package Currency.webclient.currency;

import Currency.model.CurrencyTimeFrameDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CurrencyTimeFrameCreator {

    public CurrencyTimeFrameDto createCurrencyTimeFrame(LocalDate startDate, LocalDate endDate) {
        return CurrencyTimeFrameDto.builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
