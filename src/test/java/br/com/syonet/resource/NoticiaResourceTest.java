package br.com.syonet.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class NoticiaResourceTest {
    @Test
    void testCreate() {
        String noticiaJson = """
        {
                "titulo": "Noticia teste",
                "descricao": "Esta descricao é apenas um teste",
                "url": "https://www.teste.com"
        }
    """;

        given()
            .contentType("application/json")
            .body(noticiaJson)
            .when()
            .post("/noticias")
            .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("titulo", equalTo("Noticia teste"))
            .body("descricao", equalTo("Esta descricao é apenas um teste"));
    }

    @Test
    void testListarNoticias() {

        String noticiaJson = """
        {
                "titulo": "Noticia teste",
                "descricao": "Esta descricao é apenas um teste",
                "url": "https://www.teste.com"
        }
        """;

        given()
            .contentType("application/json")
            .body(noticiaJson)
            .when()
            .post("/noticias")
            .then()
            .statusCode(201);

        given()
            .when()
            .get("/noticias")
            .then()
            .statusCode(200)
            .body("[0].titulo", not(emptyOrNullString()))
            .body("[0].descricao", not(emptyOrNullString()));
    }
}
