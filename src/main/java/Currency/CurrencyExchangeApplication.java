package Currency;

import Currency.service.CurrencyService;
import Currency.webclient.currency.CurrencyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeApplication {

	public static void main(String[] args) {
		CurrencyClient client = new CurrencyClient();
		client.getCurrencyForUsd("USD");
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}

}
