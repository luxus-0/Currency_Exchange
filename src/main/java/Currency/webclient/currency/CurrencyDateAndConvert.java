package Currency.webclient.currency;

import Currency.exception.CurrencyDateNotFoundException;
import Currency.model.CurrencyConverterDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDateAndConvert {

    private Set<LocalDate> currenciesDateDto;
    private Set<CurrencyConverterDto> currenciesConverterDto;
    private CurrencyConvert currencyConvert;
    private CurrencyDateCreator dateCreator;
    private CurrencyConverterCreator converterCreator;

    public Set<LocalDate> getCurrencyDateWithConverter(@DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate date, String from, String to, Float amount) throws Exception {
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
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency converter not found!!"));
        return currenciesDateDto;
    }
}