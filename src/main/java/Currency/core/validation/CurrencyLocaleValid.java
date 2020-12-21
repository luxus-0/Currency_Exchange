package Currency.core.validation;

import Currency.infranstructure.CurrencyLocaleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CurrencyLocaleValid {

    public void valid(List<CurrencyLocaleService> currencies) {
        if (currencies != null) {
            log.info(currencies);
            currencies.forEach(System.out::println);
        } else {
            log.error("Currencies locale is empty!!");
            throw new RuntimeException("Currencies locale is empty!!");

        }
    }
}
