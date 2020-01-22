package io.alfredux.quarkus.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private Double amount;

    private UUID uuid;

    private LocalDateTime timestamp;

    private Transaction(Double amount, LocalDateTime timestamp, UUID uuid) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }

    public static Transaction of(Double amount) {
        return new Transaction(amount, LocalDateTime.now(), UUID.randomUUID());
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
