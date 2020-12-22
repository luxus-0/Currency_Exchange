package Currency.domain.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CurrencyNbp {

    public ClientResponse getCurrencyBuyingAndSell(char table)
    {
        Client nbp = Client.create();
        WebResource source  = nbp.resource("http://api.nbp.pl/api/exchangerates/tables/table/");
        ClientResponse response = source.accept("application/json").get(ClientResponse.class);
        if(response.getStatus() != 200)
        {
            log.info("Error status code: " + response.getStatusInfo());
        }
        else
        {
            Set.of(response)
                    .stream()
                    .filter(p -> p.getStatus() == 200)
                    .collect(Collectors.toSet()).forEach(System.out::println);
        }

        return response;
    }
}
