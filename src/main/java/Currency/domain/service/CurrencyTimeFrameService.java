package Currency.domain.service;

import Currency.domain.model.dto.CurrencyTimeFrameDto;
import Currency.core.validation.CurrencyTimeFrameValid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyTimeFrameService {

    private final CurrencyTimeFrameCreator creator;
    private final CurrencyTimeFrameValid currencyTimeFrameValid;
    private final CurrencyUrlService url;

    public CurrencyTimeFrameDto getCurrencyTimeFrame(String currencies, LocalDate startDate, LocalDate endDate)
    {
        currencyTimeFrameValid.valid(startDate, endDate);
        Set<String> currenciesTimeFrame = Set.of(currencies);
        CurrencyTimeFrameDto currencyTimeFrameDto = creator.createCurrencyTimeFrame(new CurrencyTimeFrameDto(currenciesTimeFrame, startDate,endDate));
        log.info(currenciesTimeFrame);
        getUrlTimeFrame(currencies,startDate,endDate);
        return currencyTimeFrameDto;
    }

    public String getUrlTimeFrame(String currencies,LocalDate startDate,LocalDate endDate)
    {
        return  url.getUrl() +"timeframe" +url.getKey() +" &currencies=" + currencies + "&startDate=" + startDate + "&endDate="+endDate;
    }
}
