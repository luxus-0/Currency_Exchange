package Currency.domain.service;

import Currency.domain.model.CurrencyTimeFrameDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyTimeFrameCreator {

    public CurrencyTimeFrameDto createCurrencyTimeFrame(CurrencyTimeFrameDto currencyTimeFrameDto) {
        return CurrencyTimeFrameDto.builder()
                .startDate(currencyTimeFrameDto.getStartDate())
                .endDate(currencyTimeFrameDto.getEndDate())
                .currenciesTimeFrame(currencyTimeFrameDto.getCurrenciesTimeFrame())
                .build();
    }
}
