package Currency.domain.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        String currencyToday = response.getEntity(String.class);
        if(response.getStatus() != 200)
        {
            log.info("Error status code: " + response.getStatus());
        }
        else
        {
            Set.of(currencyToday)
                    .stream()
                    .filter(p -> response.getStatus() == 200)
                    .collect(Collectors.toSet()).forEach(System.out::println);
        }
        return currencyToday;
    }

    public String getCurrencyDate(char table, LocalDate date)
    {
        Client nbp = Client.create();
        WebResource source  = nbp.resource(url.getUrlNbp(table) +"/"+date);
        ClientResponse response = source.accept("application/json").get(ClientResponse.class);
        String currencyDate = response.getEntity(String.class);
        if(response.getStatus() != 200)
        {
            log.info("Error status code: " + response.getStatus());
        }
        else
        {
           List<LocalDate> dateCurrency = new ArrayList<>();
           dateCurrency.add(date);
           dateCurrency.stream().filter(p -> p.getYear() > 2003).forEach(System.out::println);
        }
        return currencyDate;
    }

    public String getCurrencyDateByPeriod(char table, LocalDate startDate, LocalDate endDate)
    {
        return "";
    }
}
