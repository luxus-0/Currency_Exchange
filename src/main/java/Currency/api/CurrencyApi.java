package Currency.api;

import Currency.domain.service.CurrencyClient;
import Currency.domain.model.dto.*;
import Currency.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CurrencyApi {

    private final CurrencyClient currencyClient;
    private final CurrencyScheduledService currencyScheduledService;
    private final CurrencyDateService currencyDateService;
    private final CurrencyConverterService currencyConverterService;
    private final CurrencyDateAndConvert currencyDateAndConvert;
    private final CurrencyTimeFrameService currencyTimeFrameService;

    @GetMapping("/currencies")
    public void getCurrency() throws Exception {
        currencyScheduledService.getCurrency();
    }

    @GetMapping("/currencies/live")
    public void getLiveCurrency() throws Exception {
        currencyScheduledService.getCurrencyLive();
    }

    @GetMapping("/currencies/{date}")
    public CurrencyDateDto getCurrencyDateService(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date) throws Exception {
        return currencyDateService.getCurrencyDate(date);
    }

    @GetMapping("/currencies/{currencies}/{amount}/{source}")
    public CurrencyDto getCurrencyAmountWithSource(@PathVariable String currencies, @PathVariable Float amount, @PathVariable String source)
    {
        return currencyClient.getCurrencyAmountWithSource(currencies,amount, source);
    }

    @GetMapping("/currencies/{date}/{from}/{to}/{amount}")
    public CurrencyDateAndConvertDto getCurrencyDateWithConvert(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date, @PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyDateAndConvert.getCurrencyDateWithConverter(date, from, to, amount);
    }

    @GetMapping("/currencies/convert/{from}/{to}/{amount}")
    public CurrencyConverterDto getCurrencyConverterService(@PathVariable String from, @PathVariable String to, @PathVariable Float amount) throws Exception {
        return currencyConverterService.convert(from, to, amount);
    }

    @GetMapping("/currencies/timeFrame/{currencies}/{startDate}/{endDate}")
    public CurrencyTimeFrameDto getCurrencyTimeFrameService(@PathVariable String currencies, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
        return currencyTimeFrameService.getCurrencyTimeFrame(currencies,startDate,endDate);
    }

}
