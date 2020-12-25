package Currency.api;

import Currency.domain.model.dto.AccountRequest;
import Currency.domain.model.dto.AccountResponse;
import Currency.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("api/account/{id}")
    public AccountResponse findAccount(@PathVariable Long id)
    {
        return accountService.find(id);
    }

    @PostMapping("api/account")
    public void createAccount(@RequestBody AccountRequest account)
    {
        accountService.save(account);
    }
}
