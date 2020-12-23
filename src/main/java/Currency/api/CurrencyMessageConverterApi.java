package Currency.api;

import Currency.domain.model.dto.CurrencyMessageConverterDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyMessageConverterApi {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public CurrencyMessageConverterDto send(CurrencyMessageConverterDto message)
    {
        return new CurrencyMessageConverterDto(message.getFromCurrency(), message.getToCurrency(), message.getDisplay(),message.getCreatedDate());
    }
}
