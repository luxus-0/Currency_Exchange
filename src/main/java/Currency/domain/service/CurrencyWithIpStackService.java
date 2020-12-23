package Currency.domain.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Service
@Log4j2
public class CurrencyWithIpStackService {

    public InetAddress showLocalHost() throws UnknownHostException {
        InetAddress inet6Address = Inet6Address.getLocalHost();
        log.info("Localhost: " +inet6Address);
        return inet6Address;
    }

    public String getHostName() throws UnknownHostException {
        String hostName = showLocalHost().getHostName();
        log.info("Host name: " +hostName);
        return hostName;
    }

    public String showIpAddress() throws UnknownHostException {
        InetAddress inet6Address = Inet6Address.getLocalHost();
        String ip = Arrays.toString(inet6Address.getAddress());
        log.info("Ip address this pc: " +ip);
        return ip;
    }

    public String getIpAddress(String ip) {
        log.info("Ip address: " +ip);
        return ip;
    }
}
