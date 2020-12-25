package Currency.domain.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String currency;
    private Long userId;
    private BigDecimal rate;

    public Account(BigDecimal balance, String currency,BigDecimal rate) {
        this.balance = balance;
        this.currency = currency;
        this.rate = rate;

    }
}
