package Currency.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyConverterDto {
    private Long id;
    private String from;
    private String to;
    private float amount;
}
