package Currency.domain.service;

import Currency.core.exception.CurrencyDateNotFoundException;
import Currency.domain.model.dto.CurrencyConverterDto;
import Currency.domain.model.dto.CurrencyDateAndConvertDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyDateAndConvert {

    private final Set<LocalDate> currenciesDateDto;
    private Set<CurrencyConverterDto> currenciesConverterDto;
    private final CurrencyConverter currencyConverter;
    private final CurrencyDateCreator dateCreator;
    private final CurrencyConverterCreator converterCreator;


    public CurrencyDateAndConvertDto getCurrencyDateWithConverter(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, String from, String to, Float amount) throws Exception {
        currenciesConverterDto = Set.of(currencyConverter.convert(from,to,amount));
        dateCreator.create(Set.of(date));
        converterCreator.create(currencyConverter.convert(from,to,amount));

        currenciesDateDto.stream()
                .filter(p -> p.getYear() > 1900)
                .findAny()
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency date not found!!"));

        currenciesConverterDto.stream()
                .filter(p -> p.getFrom().equals(from) && p.getTo().equals(to) && p.getAmount() > 0)
                .findAny()
                .orElseThrow(() -> new CurrencyDateNotFoundException("currency converter not found!!"));

        return new CurrencyDateAndConvertDto(currenciesConverterDto,currenciesDateDto);
    }
}