package Currency.api;

import Currency.domain.model.entity.Transfer;
import Currency.domain.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransferApi {

    private final TransferService transferService;

    @PostMapping("/api/transfer")
    public void createTransfer(@RequestBody Transfer transfer)
    {
        transferService.createTransfer(transfer);
    }
}
