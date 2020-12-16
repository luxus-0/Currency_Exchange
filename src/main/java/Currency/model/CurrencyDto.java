package Currency.model;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Getter
@Builder
@AllArgsConstructor
@Setter
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private Float amount;
   private String source;

   public CurrencyDto() {

      currencies.add("USD");
      currencies.add("EUR");
      currencies.add("PLN");

      currencies.stream().filter(p -> p.length() > 0)
              .findAny().orElseThrow();
   }
}
