package pl.wilczynski.homeplanner.backend.dao.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.wilczynski.homeplanner.backend.model.budget.BudgetEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BudgetDataAccessService implements BudgetEntryDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BudgetDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<BudgetEntry> DB = new ArrayList<>();

    @Override
    public int insertBudgetEntry(UUID id, BudgetEntry budgetEntry) {

        DB.add(new BudgetEntry(id,
                budgetEntry.getDate(),
                budgetEntry.getDescription(),
                budgetEntry.getValue(),
                budgetEntry.getCurrency()));
        return 1;



    }

    @Override
    public List<BudgetEntry> getAllBudgetEntries() {
        return DB;
    }

    @Override
    public Optional<BudgetEntry> getBudgetEntryById(UUID id) {
        return DB.stream()
                .filter(budgetEntry -> budgetEntry.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBudgetEntryById(UUID id) {
        Optional<BudgetEntry> budgetEntry = getBudgetEntryById(id);
        if(budgetEntry.isEmpty()){
            return 0;
        }
        DB.remove(budgetEntry.get());
        return 1;
    }

    @Override
    public int updateBudgetEntryById(UUID id, BudgetEntry budgetEntryUpdate) {
        return getBudgetEntryById(id)
                .map(budEnt -> {
                    int indexOfBudgetEntryToDelete = DB.indexOf(budEnt);
                    if (indexOfBudgetEntryToDelete >= 0) {
                        DB.set(indexOfBudgetEntryToDelete, budgetEntryUpdate);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
