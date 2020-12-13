package Currency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SourceCurrencyNotFoundException extends RuntimeException {
    public SourceCurrencyNotFoundException(String sourceCurrency) {
    }
}
