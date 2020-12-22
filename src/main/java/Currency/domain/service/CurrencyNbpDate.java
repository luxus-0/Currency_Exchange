package Currency.domain.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyNbpDate {

    private final CurrencyUrl url;

    public String getCurrencyToday(char table)
    {
        Client nbp = Client.create();
        WebResource source  = nbp.resource(url.getUrlNbp(table) +"/today");
        ClientResponse response = source.accept("application/json").get(ClientResponse.class);
        String currencyJson = response.getEntity(String.class);
        if(response.getStatus() != 200)
        {
            log.info("Error status code: " + response.getStatus());
        }
        else
        {
            Set.of(currencyJson)
                    .stream()
                    .filter(p -> response.getType() == MediaType.APPLICATION_JSON_TYPE)
                    .collect(Collectors.toSet()).forEach(System.out::println);
        }
        return currencyJson;
    }
}
