package Currency.model;

import Currency.exception.CurrencyDateNotFoundException;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Log4j2
public class CurrencyDateDto {

    private Set<LocalDate> currenciesDateDto;
    private CurrencyConverterDto converterDto;

    public Set<LocalDate> get()
    {
        currenciesDateDto = Set.of(LocalDate.now(),LocalDate.of(2020,11,7));
        CurrencyConverterDto convert = new CurrencyConverterDto(1L,"USD","EUR",12);
        CurrencyDateDto dateDto = CurrencyDateDto.builder()
                .currenciesDateDto(currenciesDateDto)
                .converterDto(convert)
                .build();
        currenciesDateDto.stream()
                .filter(p -> p.getYear() > 1900)
                .findAny()
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency date not found!!"));
        log.info(currenciesDateDto.size());

        return currenciesDateDto;
    }
}
