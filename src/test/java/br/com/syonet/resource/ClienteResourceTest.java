package br.com.syonet.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ClienteResourceTest{

    @Test
    void testCreate() {
        String clienteJson = """
            {
                "nome": "Teste da Silva",
                "email": "testedasilva@gmail.com",
                "nascimento": "1999-01-31"
            }
        """;

        given()
            .contentType("application/json")
            .body(clienteJson)
            .when()
            .post("/clientes")
            .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("nome", equalTo("Teste da Silva"))
            .body("email", equalTo("testedasilva@gmail.com"));
    }

    @Test
    void testListarClientes() {

        String clienteJson = """
            {
                "nome": "Teste da Silva",
                "email": "testedasilva@gmail.com",
                "nascimento": "1999-01-31"
            }
        """;
    
        given()
            .contentType("application/json")
            .body(clienteJson)
            .when()
            .post("/clientes")
            .then()
            .statusCode(201);

        given()
            .when()
            .get("/clientes")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].nome", not(emptyOrNullString()))
            .body("[0].email", not(emptyOrNullString()));
    }
}
