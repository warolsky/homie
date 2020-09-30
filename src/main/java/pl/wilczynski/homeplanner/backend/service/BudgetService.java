package pl.wilczynski.homeplanner.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.wilczynski.homeplanner.backend.dao.budget.BudgetEntryDao;
import pl.wilczynski.homeplanner.backend.model.budget.BudgetEntry;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BudgetService {

    private final BudgetEntryDao budgetEntryDao;

    @Autowired
    public BudgetService(@Qualifier("postgres") BudgetEntryDao budgetEntryDao) {
        this.budgetEntryDao = budgetEntryDao;
    }

    public int addBudgetEntry(BudgetEntry budgetEntry){
        return budgetEntryDao.insertBudgetEntry(budgetEntry);
    }

    public List<BudgetEntry> getAllBudgetEntries() {
        return budgetEntryDao.getAllBudgetEntries();
    }

    public Optional<BudgetEntry> getBudgetEntryById(UUID id){
        return budgetEntryDao.getBudgetEntryById(id);
    }

    public int deleteBudgetEntry(UUID id){
        return budgetEntryDao.deleteBudgetEntryById(id);
    }

    public int updateBudgetEntry(UUID id, BudgetEntry budgetEntry){
        return budgetEntryDao.updateBudgetEntryById(id, budgetEntry);
    }

}
