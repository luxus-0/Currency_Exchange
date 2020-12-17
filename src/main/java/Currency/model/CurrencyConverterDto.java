package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CurrencyConverterDto {
    private final String from;
    private final String to;
    private final Float amount;
}
