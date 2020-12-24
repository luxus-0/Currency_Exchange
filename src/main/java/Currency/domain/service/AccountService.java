package Currency.domain.service;

import Currency.domain.model.dto.AccountRequest;
import Currency.domain.model.dto.AccountResponse;
import Currency.domain.model.entity.Account;
import Currency.infranstructure.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public AccountResponse find(Long id)
    {
        return repository
                .findById(id)
                .map(account -> AccountResponse.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .id(account.getId())
                        .userId(account.getUserId())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Account with id: " + id + "not found!"));
    }

    public void save(AccountRequest request)
    {
        repository.save(
                Account.builder()
                        .balance(request.getBalance())
                        .currency(request.getCurrency())
                        .userId(request.getUserId())
                        .build());
    }
}
