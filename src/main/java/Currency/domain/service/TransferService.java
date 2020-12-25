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
                transfer.getFromAccount(),
                transfer.getToAccount(),
                transfer.getAmount());

        repository.save(
                Transfer.builder()
                .amount(transfer.getAmount())
                .currency(transfer.getCurrency())
                .fromAccount(transfer.getFromAccount())
                .toAccount(transfer.getToAccount())
                .dateTransfer(transfer.getDateTransfer()
                )
                .build()
        );
    }
}
