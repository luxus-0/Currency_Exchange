package Currency.domain.service;

import Currency.domain.model.CurrencyConverterDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterCreator {

    public CurrencyConverterDto create(CurrencyConverterDto currencyConverterDto) {
        return CurrencyConverterDto.builder()
                .from(currencyConverterDto.getFrom())
                .to(currencyConverterDto.getTo())
                .amount(currencyConverterDto.getAmount())
                .build();
    }
}
