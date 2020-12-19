package Currency.webclient.currency;

import Currency.model.CurrencyConverterDto;
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
