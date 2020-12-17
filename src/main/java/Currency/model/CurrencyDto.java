package Currency.model;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class CurrencyDto {

   private final Set<String> currencies = new HashSet<>();
   private final Float amount;
   private final String source;
}
