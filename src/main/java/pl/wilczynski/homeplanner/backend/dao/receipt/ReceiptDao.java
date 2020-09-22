package pl.wilczynski.homeplanner.backend.dao.receipt;

import pl.wilczynski.homeplanner.backend.model.budget.BudgetEntry;
import pl.wilczynski.homeplanner.backend.model.receipt.Receipt;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReceiptDao {
    int insertReceipt(UUID id, Receipt receipt);

    default int insertReceipt(Receipt receipt){
        UUID id = UUID.randomUUID();
        return insertReceipt(id, receipt);
    }

    List<Receipt> getAllReceipts();

    Optional<Receipt> getReceiptById(UUID id);

    int deleteReceiptById(UUID id);

    int updateReceiptById(UUID id, Receipt receipt);
}
