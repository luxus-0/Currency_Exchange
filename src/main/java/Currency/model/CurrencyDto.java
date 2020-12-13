package Currency.model;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

   private String usd;
   private String euro;
   private String pln;
   private float amount;
}
