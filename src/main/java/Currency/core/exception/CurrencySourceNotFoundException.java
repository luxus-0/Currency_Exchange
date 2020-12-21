package Currency.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencySourceNotFoundException extends RuntimeException {
    public CurrencySourceNotFoundException(String sourceCurrency) {
    }
}
