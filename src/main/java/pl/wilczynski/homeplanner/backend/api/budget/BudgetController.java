package pl.wilczynski.homeplanner.backend.api.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wilczynski.homeplanner.backend.model.budget.BudgetEntry;
import pl.wilczynski.homeplanner.backend.service.BudgetService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/budget")
@RestController
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public void addBudgetEntry(@RequestBody BudgetEntry budgetEntry) {
        budgetService.addBudgetEntry(budgetEntry);
    }

    @GetMapping
    public List<BudgetEntry> getAllBudgetEntries(){
        return budgetService.getAllBudgetEntries();
    }

    @GetMapping(path = "/{id}")
    public BudgetEntry getBudgetEntryById(@PathVariable("id") UUID id){
        return budgetService.getBudgetEntryById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public int deleteBudgetEntryById(@PathVariable("id") UUID id){
        return budgetService.deleteBudgetEntry(id);
    }

    @PutMapping(path = "/{id}")
    public int updateBudgetEntryById(@PathVariable("id") UUID id, @RequestBody BudgetEntry budgetEntry){
        return budgetService.updateBudgetEntry(id, budgetEntry);
    }



}
