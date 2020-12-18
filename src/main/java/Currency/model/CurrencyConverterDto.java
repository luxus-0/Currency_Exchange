package Currency.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CurrencyConverterDto {
    private final String from;
    private final String to;
    private final Float amount;

    @Builder
    public CurrencyConverterDto(String from, String to, Float amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
