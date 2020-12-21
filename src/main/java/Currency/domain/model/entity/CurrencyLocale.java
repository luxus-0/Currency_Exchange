package Currency.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyLocale {

    private Long id;
    private String name;
}
