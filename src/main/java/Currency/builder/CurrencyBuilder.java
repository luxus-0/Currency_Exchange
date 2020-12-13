package Currency.builder;

import Currency.model.CurrencyDto;

public class CurrencyBuilder {

    public CurrencyDto buildCurrencyPln(CurrencyDto currencyPlnDto)
    {
        return CurrencyDto.builder()
                .pln("PLN")
                .build();
    }

    public CurrencyDto buildCurrencyEuro(CurrencyDto currencyEuroDto)
    {
        return CurrencyDto.builder()
                .euro("EUR")
                .build();
    }

    public CurrencyDto buildCurrencyUsd(CurrencyDto currencyUsdDto)
    {
        return CurrencyDto.builder()
                .usd("USD")
                .build();
    }
}
