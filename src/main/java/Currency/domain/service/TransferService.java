package Currency.domain.service;

import Currency.domain.model.entity.Transfer;
import Currency.infranstructure.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository repository;
    private final AccountService accountService;

    public void createTransfer(Transfer transfer)
    {
        accountService.transferMoney(
                transfer.getFromAccountId(),
                transfer.getToAccountId(),
                transfer.getAmount());

        repository.save(
                Transfer.builder()
                .amount(transfer.getAmount())
                .currency(transfer.getCurrency())
                .fromAccountId(transfer.getFromAccountId())
                .toAccountId(transfer.getToAccountId())
                .dateTransfer(transfer.getDateTransfer()
                )
                .build()
        );
    }
}
