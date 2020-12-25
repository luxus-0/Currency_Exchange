package Currency.api;

import Currency.domain.service.CurrencyNbpDateService;
import Currency.domain.service.CurrencyNbpService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.net.http.HttpResponse;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CurrencyNbpApi {

    private final CurrencyNbpService currencyNbpService;
    private final CurrencyNbpDateService currencyNbpDateService;

    @GetMapping("/currencies/nbp/{table}")
    public String getCurrencyBuyingAndSell(@PathVariable char table)
    {
        return currencyNbpService.getCurrencyBuyingAndSell(table);
    }

    @GetMapping("/currencies/nbp/{table}/today")
    public String getCurrencyDateByToday(@PathVariable char table)
    {
        return currencyNbpDateService.getCurrencyToday(table);
    }

    @GetMapping("/currencies/nbp/{table}/{date}")
    public String getCurrencyDates(@PathVariable char table, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return currencyNbpDateService.getCurrencyDate(table,date);
    }

    @GetMapping("/currencies/nbp/{table}/{startDate}/{endDate}")
    public HttpResponse<String> getCurrencyDatePeriod(@PathVariable char table, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
        return currencyNbpDateService.getCurrencyDateByPeriod(table,startDate,endDate);
    }
}
