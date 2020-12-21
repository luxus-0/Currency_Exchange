package Currency.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConverterDto {
    private String from;
    private String to;
    private Float amount;
}
