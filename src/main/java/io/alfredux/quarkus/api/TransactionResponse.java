package io.alfredux.quarkus.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.alfredux.quarkus.domain.model.Transaction;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {

    private Double amount;

    private UUID uuid;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    public TransactionResponse(Double amount, UUID uuid, LocalDateTime timestamp) {
        this.amount = amount;
        this.uuid = uuid;
        this.timestamp = timestamp;
    }

    public static TransactionResponse of(Transaction transaction) {
        return new TransactionResponse(transaction.getAmount(), transaction.getUuid(), transaction.getTimestamp());
    }

    public Double getAmount() {
        return amount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
