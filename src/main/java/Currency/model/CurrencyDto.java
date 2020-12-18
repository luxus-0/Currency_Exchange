package Currency.model;

import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private final Float amount;
   private final String source;

   @Builder
   public CurrencyDto(Float amount, String source) {
      this.amount = amount;
      this.source = source;
   }
}
