package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Locale;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CurrencyDto {

    private Long id;
    private String from;
    private String to;
    private BigDecimal amount;
    private Locale locale;
}
