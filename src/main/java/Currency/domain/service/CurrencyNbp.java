package Currency.domain.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyNbp {

    private final CurrencyUrl url;
    public String getCurrencyBuyingAndSell(char table)
    {
        Client nbp = Client.create();
        WebResource source  = nbp.resource(url.getUrlNbp(table));
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
                    .filter(p -> response.getStatus() == 200)
                    .collect(Collectors.toSet()).forEach(System.out::println);
        }
        return currencyJson;
    }
}