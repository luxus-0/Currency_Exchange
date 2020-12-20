package Currency.webclient.currency;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@Log4j2
public class CurrencyWithIpStack {

    public InetAddress showIpAddress() throws UnknownHostException {
        InetAddress inet6Address = Inet6Address.getLocalHost();
        log.info(inet6Address);
        return inet6Address;
    }

    public String getHostName() throws UnknownHostException {
        String hostName = showIpAddress().getHostName();
        log.info(hostName);
        return hostName;
    }
}
