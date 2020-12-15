package Currency.model;

import Currency.exception.CurrencyDateNotFoundException;
import Currency.webclient.currency.CurrencyConvert;
import Currency.webclient.currency.CurrencyConverterCreator;
import Currency.webclient.currency.CurrencyDateCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Set<CurrencyConverterDto> currenciesConverterDto;
    private CurrencyConvert currencyConvert;
    private CurrencyDateCreator dateCreator;
    private CurrencyConverterCreator converterCreator;

    public Set<LocalDate> get(LocalDate date,String from,String to,Float amount) throws Exception {
        currenciesDateDto = Set.of(date);
        currenciesConverterDto = Set.of(currencyConvert.convert(from,to,amount));
        dateCreator.create(currenciesDateDto);
        converterCreator.create(currencyConvert.convert(from,to,amount));
        currenciesDateDto.stream()
                .filter(p -> p.getYear() > 1900)
                .findAny()
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency date not found!!"));
        currenciesConverterDto.stream()
                .filter(p -> p.getFrom().equals(from) && p.getTo().equals(to) && p.getAmount() > 0)
                .findAny()
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency date not found!!"));
        return currenciesDateDto;
    }
}
