package io.alfredux.quarkus.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest {

    private Double amount;

    @JsonCreator
    public TransactionRequest(@JsonProperty Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

}
