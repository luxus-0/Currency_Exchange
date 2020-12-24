package Currency.api;

import Currency.domain.service.CurrencyUrlService;
import Currency.domain.service.CurrencyWithIpStackService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;

@RestController
@RequiredArgsConstructor
public class GeoLocalizationApi {

    private final CurrencyWithIpStackService ipStack;
    private final CurrencyUrlService url;

    @GetMapping("/currencyLocalHost")
    public InetAddress getLocalHostCurrency() throws Exception {
        return ipStack.showLocalHost();
    }

    @GetMapping("/currencyHostName")
    public String getHostNameCurrency() throws Exception {
        return ipStack.getHostName();
    }

    @GetMapping("/currencyIpAddress")
    public String getIpCurrency() throws Exception {
        return ipStack.showIpAddress();
    }

    @GetMapping("/showIpStack")
    public String showIpStackCurrency() throws Exception {
        return url.showUrlIpStack();
    }

    @GetMapping("/getIpStack/{ipAddress}")
    public String getIpStackCurrency(@PathVariable String ipAddress) {
        return ipStack.getIpAddress(ipAddress);
    }

}
