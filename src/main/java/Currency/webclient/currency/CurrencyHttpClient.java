package Currency.webclient.currency;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CurrencyHttpClient {

    @Scheduled(fixedRate = 6000)
    public void getCurrency() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() +getKey()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        log.info("Currency: " +jsonObject);
    }

    @Scheduled(fixedRate = 6000)
    public void getBaseCurrency() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() + getKey() + "&format=1"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        log.info("Base Currency: " +jsonObject);
    }

    @Scheduled(fixedRate = 6000)
    public void getDateCurrency()
    {
        if(getUrlDateCurrency().isEmpty())
        {
            log.info("Currency date is empty");
        }
        else
        {
            List<LocalDate> date = List.of(
                    LocalDate.now()
                    ,LocalDate.of(2020,12,11)
                    ,LocalDate.of(2020,11,9)
                    ,LocalDate.of(2020,12,1)
                    ).stream().filter(p -> p.getYear() == 2020).collect(Collectors.toList());

            JSONObject object = new JSONObject(getUrlDateCurrency());
            String dateCurrency = object.getString(date.toString());
            log.info(dateCurrency);

        }
    }

    @Scheduled(fixedRate = 6000)
    public void convertFromEuroToGbp() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() + getKey() + getUrlConverter() + "&format=1"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        if(jsonObject.isEmpty())
        {
            log.info("Empty currency convertion ");
        }
        else
        {
            log.info(jsonObject);
        }
    }

    public String getUrl()
    {
        return "http://api.currencylayer.com/";
    }

    public String getUrlLiveCurrency()
    {
        return getUrl() +"live?";
    }

    public String getUrlConverter()
    {
        return "/convert?from=EUR&to=GBP";
    }

    public String getUrlDateCurrency()
    {
        return getUrl() +"historical?"+ getKey()+"/date=YYYY-MM-DD";
    }

    public String getKey()
    {
        return "access_key=c3a793be6c037bb9b765cbd61037d4a0";
    }

}
