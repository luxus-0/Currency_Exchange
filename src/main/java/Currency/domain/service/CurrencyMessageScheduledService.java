package Currency.domain.service;

import Currency.domain.model.dto.CurrencyMessageConverterDto;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CurrencyMessageScheduledService {

    private final SimpMessagingTemplate template;

    public void sendCurrencyMessage()
    {
        CurrencyMessageConverterDto dateMessage = CurrencyMessageConverterDto.builder()
                .createdDate(LocalDate.now())
                .build();

        template.convertAndSend("/topic/pushmessages",new CurrencyMessageConverterDto("USD","PLN","Conversion complete",dateMessage.getCreatedDate()));
    }
}
