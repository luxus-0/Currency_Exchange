package Currency.model;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Log4j2
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private float amount;
   private String source;

   public CurrencyDto() {

      currencies.add("USD");
      currencies.add("EUR");
      currencies.add("PLN");

      currencies.stream().filter(p -> p.length() > 0)
              .findAny().orElseThrow();

      log.info("Currencies");
   }
}
