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

//    List<BudgetEntry> DB = new ArrayList<>();

    @Override
    public int insertBudgetEntry(UUID id, BudgetEntry budgetEntry) {

        final String sql = "INSERT INTO budget VALUES (id = ?, " +
                "date = ?, " +
                "description = ?, " +
                "value = ?, " +
                "currency = ?)";

        jdbcTemplate.update(sql, new Object[]{
                id,
                budgetEntry.getDate(),
                budgetEntry.getDescription(),
                budgetEntry.getValue(),
                budgetEntry.getCurrency()
        });

        return 1;

    }

    @Override
    public List<BudgetEntry> getAllBudgetEntries() {

        final String sql = "SELECT id, date, description, value, currency FROM budget";
        List<BudgetEntry> budgetEntry = jdbcTemplate.query(sql, (resultSet, i) -> new BudgetEntry(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("date"),
                resultSet.getString("description"),
                Float.valueOf(resultSet.getString("value")),
                resultSet.getString("currency")
        ));
        return budgetEntry;

    }

    @Override
    public Optional<BudgetEntry> getBudgetEntryById(UUID id) {

        final String sql = "SELECT id, date, description, value, currency FROM budget WHERE id = ?";
        BudgetEntry budgetEntry = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> new BudgetEntry(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("date"),
                resultSet.getString("description"),
                Float.valueOf(resultSet.getString("value")),
                resultSet.getString("currency")
        ));
        return Optional.ofNullable(budgetEntry);

    }

    @Override
    public int deleteBudgetEntryById(UUID id) {

        final String sql = "DELETE FROM budget WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
        return 1;

    }

    @Override
    public int updateBudgetEntryById(UUID id, BudgetEntry budgetEntryUpdate) {

        final String sql = "UPDATE budget " +
                "SET " +
                "id = ?, " +
                "date = ?, " +
                "description = ?, " +
                "value = ?, " +
                "currency = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
                budgetEntryUpdate.getId(),
                budgetEntryUpdate.getDate(),
                budgetEntryUpdate.getDescription(),
                budgetEntryUpdate.getValue(),
                budgetEntryUpdate.getCurrency(),
                id});
        return 1;

    }

}
