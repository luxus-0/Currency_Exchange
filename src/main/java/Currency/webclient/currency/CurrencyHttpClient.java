package Currency.webclient.currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void getDateCurrency() throws JsonProcessingException {
        if(getUrlDateCurrency().isEmpty())
        {
            log.info("Currency date is empty");
        }
        else
        {
            getDate();
            JSONObject currencyDate = new JSONObject(getUrlDateCurrency().indexOf(""));
            JSONObject currencyDate2 = new JSONObject(getDate().indexOf(""));

            log.info(currencyDate.getString("2020-12-05"));
            log.info(currencyDate2.getString("2020-11-08"));


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
        return getUrl() +"historical?"+ getKey()+"/date="+getDate();
    }

    public String getKey()
    {
        return "access_key=c3a793be6c037bb9b765cbd61037d4a0";
    }

    public String getDate()
    {

        return new ArrayList<>(List.of(
                LocalDate.now()
                , LocalDate.of(2020, 12, 5)
                , LocalDate.of(2020, 11, 9)
                , LocalDate.of(2020, 12, 1)
        )).toString();
    }
}
