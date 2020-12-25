package Currency.domain.service;

import Currency.core.exception.FromAccountByAmountNotFoundException;
import Currency.domain.model.dto.AccountRequest;
import Currency.domain.model.dto.AccountResponse;
import Currency.domain.model.entity.Account;
import Currency.infranstructure.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public AccountResponse find(Long id) {
        return repository
                .findById(id)
                .map(account -> AccountResponse.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .id(account.getId())
                        .userId(account.getUserId())
                        .rate(account.getRate())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Account with id: " + id + "not found!"));
    }

    public void save(AccountRequest request) {
        repository.save(
                Account.builder()
                        .balance(request.getBalance())
                        .currency(request.getCurrency())
                        .userId(request.getUserId())
                        .rate(request.getRate())
                        .build());
    }

    public void transferMoney(long fromAccountId, long toAccountId, BigDecimal rate, BigDecimal amount)
    {
        validAmount(amount);
        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException("Don't transfer to the same account");
        }

        Account fromAccount = repository
                .findById(fromAccountId)
                .map(account -> Account.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .id(account.getId())
                        .userId(account.getUserId())
                        .rate(account.getRate())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("From Account id: " + fromAccountId + "not found!"));


        Account toAccount = repository
                .findById(toAccountId)
                .map(account -> Account.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .id(account.getId())
                        .userId(account.getUserId())
                        .rate(account.getRate())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("To Account id: " + toAccountId + "not found!"));

    if(fromAccount.getBalance().subtract(amount).equals(fromAccount.getBalance().negate()))
    {
        throw new FromAccountByAmountNotFoundException("You haven't got any money to account in id:" +fromAccountId);
    }
    else
    {
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount.multiply(rate)));
        toAccount.setBalance(toAccount.getBalance().add(amount.multiply(rate)));
    }
    repository.save(fromAccount);
    repository.save(toAccount);


    }
        public void validAmount (BigDecimal amount)
        {
            if (amount.equals(amount.negate())) {
                throw new IllegalArgumentException("Amount must be positive number");
            }
        }
}