package pl.wilczynski.homeplanner.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Document(collection = "budgetentries")
public class BudgetEntry {

    @Id
    private final UUID id;
    private final String date;
    private final String description;
    private final float value;
    private final String currency;

    public BudgetEntry(@JsonProperty("id") @NotNull UUID id,
                       @JsonProperty("date") String date,
                       @JsonProperty("description") String description,
                       @JsonProperty("value") float value,
                       @JsonProperty("currency") String currency) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.value = value;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public float getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "BudgetEntry{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
