package pl.wilczynski.homeplanner.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wilczynski.homeplanner.backend.model.BudgetEntry;
import pl.wilczynski.homeplanner.backend.service.BudgetService;

import java.util.List;
import java.util.Optional;
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

    @GetMapping(path = "/   {id}")
    public BudgetEntry getBudgetEntryById(@PathVariable("id") UUID id){
        return budgetService.getBudgetEntryById(id)
                .orElse(null);
    }

}
