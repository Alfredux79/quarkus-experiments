package io.alfredux.quarkus.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.alfredux.quarkus.domain.model.Transaction;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
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
}
