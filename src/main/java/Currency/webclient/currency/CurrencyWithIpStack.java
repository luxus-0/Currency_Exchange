package Currency.webclient.currency;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@Log4j2
public class CurrencyWithIpStack {

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

    public byte[] showIpAddress() throws UnknownHostException {
        InetAddress inet6Address = Inet6Address.getLocalHost();
        byte[] ip = inet6Address.getAddress();
        log.info("Ip address this pc: " +ip);
        return ip;
    }

    public byte[] getIpAddress(byte[] ip) throws UnknownHostException {
        InetAddress inet6Address = Inet6Address.getLocalHost();
        ip = inet6Address.getAddress();
        log.info("Ip address this pc: " +ip);
        return ip;
    }
}
