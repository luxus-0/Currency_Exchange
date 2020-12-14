package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CurrencySourceDto {

    private final String source;
    private final Float amount;
}
