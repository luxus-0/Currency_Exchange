package Currency.webclient.currency;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class CurrencyHttpClient {

    @Scheduled(fixedRate = 6000)
    public void getAllCurrency() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() +getKey()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        log.info("Currency: " +jsonObject);
    }

    @Scheduled(fixedRate = 7000)
    public void getLiveCurrency() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlLiveCurrency() + getKey() + "&format=1"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        log.info("Base Currency: " +jsonObject);
    }

    @Scheduled(fixedRate = 8000)
    public void getDateCurrency() {
        if(getUrlDateCurrency().isEmpty())
        {
            log.info("Currency date is empty");
        }
        else
        {
            getDate();

            for(int i = 0; i < 3;i++) {
                JSONObject currencyDate = new JSONObject(getUrlDateCurrency().indexOf(i));
                JSONObject currencyDate2 = new JSONObject(getDate().indexOf(i));

                log.info(currencyDate);
                log.info(currencyDate2);
            }

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

    public String getUrlDateCurrency()
    {
        return getUrl() +"historical"+ getKey()+"/date=2020-12-05";
    }

    public String getKey()
    {
        return "?access_key=07f5f38393ee1ada9be581377906ffca";
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
