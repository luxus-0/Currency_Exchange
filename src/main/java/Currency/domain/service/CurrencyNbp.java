package Currency.domain.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CurrencyNbp {

    public void getActualCurrency()
    {
        Client nbp = Client.create();
        WebResource source  = nbp.resource("http://api.nbp.pl/api/exchangerates/tables/{table}/");
        ClientResponse response = source.accept("application/json").get(ClientResponse.class);
        if(response.getStatus() != 200)
        {
            log.info("Error status code: " + response.getStatusInfo());
        }

    }
}
