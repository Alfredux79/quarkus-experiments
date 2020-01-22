package io.alfredux.quarkus.domain.services;

import io.alfredux.quarkus.domain.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class LocalTransactionProcessor implements TransactionProcessor {

    private final static Logger LOG = LoggerFactory.getLogger(LocalTransactionProcessor.class);

    private Map<UUID, Transaction> transactions;

    @Inject
    public LocalTransactionProcessor() {
        this.transactions = new HashMap<>();
    }

    @Override
    public Transaction addTransaction(Double amount) {
        LOG.info("Creating and storing new transaction for amount {}", amount);
        Transaction transaction = Transaction.of(amount);
        transactions.put(transaction.getUuid(), transaction);
        return transaction;
    }

    @Override
    public Collection<Transaction> getTransactions() {
        return transactions.values();
    }
}