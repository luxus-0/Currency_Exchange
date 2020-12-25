package Currency.domain.model.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyConverter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurrency;
    private String fromCurrency;
    private String toCurrency;
    private Float amountCurrency;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdDate;
}
