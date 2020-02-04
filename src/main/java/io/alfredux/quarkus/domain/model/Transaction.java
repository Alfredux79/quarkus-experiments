package io.alfredux.quarkus.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Transaction {

    private UUID uuid;

    private Double amount;

    private LocalDateTime timestamp;

    private Transaction(Double amount, LocalDateTime timestamp, UUID uuid) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }

    public static Transaction of(Double amount) {
        return new Transaction(amount, LocalDateTime.now(), UUID.randomUUID());
    }

}
