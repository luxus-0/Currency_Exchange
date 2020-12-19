package Currency.webclient.currency;

import Currency.model.CurrencyDateDto;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class CurrencyDateCreator {

    public CurrencyDateDto create(Set<LocalDate> currencyDateDto)
    {
        return CurrencyDateDto.builder()
                .currenciesDateDto(currencyDateDto)
                .build();
    }
}
