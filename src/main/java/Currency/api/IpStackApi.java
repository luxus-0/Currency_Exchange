package Currency.api;

import Currency.webclient.currency.CurrencyUrl;
import Currency.webclient.currency.CurrencyWithIpStack;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;

@RestController
@AllArgsConstructor
public class IpStackApi {

    private final CurrencyWithIpStack ipStack;
    private final CurrencyUrl url;

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
