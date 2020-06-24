package pl.wilczynski.homeplanner.backend.dao;

import pl.wilczynski.homeplanner.backend.model.BudgetEntry;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetEntryDao {

    int insertBudgetEntry(UUID id, BudgetEntry budgetEntry);

    default int insertBudgetEntry(BudgetEntry budgetEntry){
        UUID id = UUID.randomUUID();
        return insertBudgetEntry(id, budgetEntry);
    }

    List<BudgetEntry> getAllBudgetEntries();

    Optional<BudgetEntry> getBudgetEntryById(UUID id);

    int deleteBudgetEntryById(UUID id);

    int updateBudgetEntryById(UUID id, BudgetEntry budgetEntry);

}
