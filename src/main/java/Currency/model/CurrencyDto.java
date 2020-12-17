package Currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private final Float amount;
   private final String source;
}
