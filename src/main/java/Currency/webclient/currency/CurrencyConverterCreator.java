package Currency.webclient.currency;

import Currency.model.CurrencyConverterDto;

public class CurrencyConverterCreator {

    public CurrencyConverterDto create(CurrencyConverterDto converterDto) {
        return CurrencyConverterDto.builder()
                .id(converterDto.getId())
                .from(converterDto.getFrom())
                .to(converterDto.getTo())
                .amount(converterDto.getAmount())
                .build();
    }
}
