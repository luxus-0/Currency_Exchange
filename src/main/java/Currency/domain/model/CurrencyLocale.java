package Currency.domain.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyLocale {

    private Long id;
    private String name;
    private List<CurrencyLocale> currenciesLocale;
}
