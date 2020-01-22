package io.alfredux.quarkus.domain.services;

import io.alfredux.quarkus.domain.model.Transaction;

import java.util.Collection;

public interface TransactionProcessor {

    Transaction addTransaction(Double amount);

    Collection<Transaction> getTransactions();
}
