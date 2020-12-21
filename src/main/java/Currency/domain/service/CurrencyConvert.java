package Currency.domain.service;

import Currency.domain.model.CurrencyConverterDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@AllArgsConstructor
@Log4j2
public class CurrencyConvert {

    private final CurrencyUrl url;

    public CurrencyConverterDto convert(String from, String to, Float amount) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(getUrlConvert(from,to,amount)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        if(jsonObject.isEmpty())
        {
            log.info("Empty currency convert!");
        }
        else
        {
            log.info(jsonObject);
        }
        return new CurrencyConverterDto(from,to,amount);
    }

    public String getUrlConvert(String from, String to, Float amount) { return url.getUrl() + "convert" + url.getKey() +"&from="+from+ "&to="+to+"&amount="+amount;};

}
