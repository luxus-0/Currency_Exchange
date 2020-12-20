package Currency.api;

import Currency.webclient.currency.CurrencyWithIpStack;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;

@RestController
@AllArgsConstructor
public class IpStackApi {

    private final CurrencyWithIpStack ipStack;

    @GetMapping("/currencyLocalHost")
    public InetAddress getLocalHostCurrency() throws Exception {
        return ipStack.showIpAddress();
    }

    @GetMapping("/currencyHostName")
    public String getHostNameCurrency() throws Exception {
        return ipStack.getHostName();
    }
}
