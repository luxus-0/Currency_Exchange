package Currency.webclient.currency;

import Currency.model.CurrencyConverterDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Log4j2
@AllArgsConstructor
public class CurrencyConvert {

    private final CurrencyUrl url;
    private final CurrencyConverterDto currencyConverterDto;

    public CurrencyConverterDto convert(String from, String to, Float amount) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url.getUrlConvert()))
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

        return currencyConverterDto;
    }
}
