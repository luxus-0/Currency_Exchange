package Currency.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponse {
    private Long id;
    private BigDecimal balance;
    private String currency;
    private Long userId;
    private BigDecimal rate;
}
