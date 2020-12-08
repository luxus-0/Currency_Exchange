package Currency.builder;

import Currency.model.CurrencyDto;

public class CurrencyBuilder {

    public CurrencyDto buildCurrencyPln(CurrencyDto currencyPlnDto)
    {
        return CurrencyDto.builder()
                .usd(currencyPlnDto.getPln())
                .build();
    }

    public CurrencyDto buildCurrencyEuro(CurrencyDto currencyEuroDto)
    {
        return CurrencyDto.builder()
                .usd(currencyEuroDto.getEuro())
                .build();
    }

    public CurrencyDto buildCurrencyUsd(CurrencyDto currencyUsdDto)
    {
        return CurrencyDto.builder()
                .usd(currencyUsdDto.getUsd())
                .build();
    }
}
