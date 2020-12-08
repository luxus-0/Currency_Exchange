package Currency.model;

import lombok.Getter;

@Getter
public class CurrencyConverterDto {
    private Long id;
    private String from;
    private String to;
    private float rates;
}
