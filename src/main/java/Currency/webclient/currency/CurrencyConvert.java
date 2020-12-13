package Currency.webclient.currency;

import Currency.model.CurrencyConverterDto;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@Log4j2
public class CurrencyConvert {

    private CurrencyUrl url;

    public CurrencyConverterDto convert(String from, String to, Float amount) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url.getUrl() + "/convert" + url.getKey() +"&from={from}&to={to}" + "&format=1" + "&amount={amount}"))
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

        return convert(from, to, amount);
    }
}
