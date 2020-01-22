package io.alfredux.quarkus.api;

import io.alfredux.quarkus.domain.services.TransactionProcessor;
import io.alfredux.quarkus.infrastructure.serialization.JsonPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/transaction")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class TransactionResource {

    private final static Logger LOG = LoggerFactory.getLogger(TransactionResource.class);

    private TransactionProcessor transactionProcessor;

    private JsonPrinter jsonPrinter;

    @Inject
    public TransactionResource(TransactionProcessor transactionProcessor, JsonPrinter jsonPrinter) {
        this.transactionProcessor = transactionProcessor;
        this.jsonPrinter = jsonPrinter;
    }

    @POST
    public TransactionResponse recordTransaction(TransactionRequest request) {
        LOG.info("Received request {}", jsonPrinter.print(request));
        return TransactionResponse.of(transactionProcessor.addTransaction(request.getAmount()));
    }

    @GET
    public List<TransactionResponse> getTransactions() {
        return transactionProcessor.getTransactions()
                .stream()
                .map(TransactionResponse::of)
                .collect(Collectors.toList());
    }

}
