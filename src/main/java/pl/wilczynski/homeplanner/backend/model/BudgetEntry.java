package pl.wilczynski.homeplanner.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BudgetEntry {

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

}
