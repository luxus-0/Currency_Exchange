package Currency.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Getter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private Float amount;
   private String source;
}
