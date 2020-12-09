package Currency.webclient.currency;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@Log4j2
public class CurrencyHttpClient {

    private final static String URL = "https://v6.exchangerate-api.com/v6/";
    private final static String API_KEY = "8adf6a6ff3e821e7c8abc2aa";

    @Scheduled(fixedRate = 6000)
    public void getCurrency() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + API_KEY + "/latest/USD"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Currencies");
        log.info(response.body());
    }

    @Scheduled(fixedRate = 6000)
    public void getCurrencyConversion() throws IOException, InterruptedException {
        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + API_KEY + "/pair/EUR/GBP"))
                .build();

        HttpResponse<String> response = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        log.info("Convert from Euro to GBP");
        log.info(response.toString());
    }
}
