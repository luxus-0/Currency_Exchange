package Currency.webclient.currency;

import Currency.exception.CurrencyConvertExceptionNotFound;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CurrencyHttpClient {

    @Scheduled(fixedRate = 6000)
    public void getAllCurrency() throws IOException, InterruptedException {
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

            for(int i = 0; i < 20;i++) {
                JSONObject currencyDate = new JSONObject(getUrlDateCurrency().indexOf(i));
                JSONObject currencyDate2 = new JSONObject(getDate().indexOf(i));

                log.info(currencyDate);
                log.info(currencyDate2);
            }

        }
    }

    @Scheduled(fixedRate = 6000)
    public void convertFromEuroToGbp() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() + getKey() +"/convert?from=EUR&to=GBP" + "&format=1"))
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

    public void convertFromEuroToPln(String amount) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() + getKey() + "/convert?from=EUR&to=GBP" + "&format=1" + "&amount={amount}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        if(jsonObject.isEmpty())
        {
            throw new CurrencyConvertExceptionNotFound("Currency converter not found");
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
        return getUrl() +"historical?"+ getKey()+"/date=2020-12-05";
    }

    public String getKey()
    {
        return "access_key=07f5f38393ee1ada9be581377906ffca";
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
