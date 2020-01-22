package io.alfredux.quarkus;

import io.alfredux.quarkus.api.TransactionRequest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class TransactionResourceTest {

    @Test
    public void testTransactionRequest() {
        Double amount = Double.valueOf(10.0);
        given()
                .contentType("application/json")
                .body(new TransactionRequest(amount))
                .when()
                .post("/transaction")
                .then()
                .statusCode(200)
                .body("amount", equalTo(10.0f))
        ;
    }

}