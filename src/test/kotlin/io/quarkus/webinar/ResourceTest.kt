package io.quarkus.webinar

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import io.restassured.RestAssured
import io.restassured.config.ObjectMapperConfig
import io.restassured.http.ContentType
import io.restassured.parsing.Parser
import org.hamcrest.CoreMatchers.*

@QuarkusTest
class ResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello")
          .then()
             .statusCode(200)
             .body(`is`("Hello RESTEasy Reactive"))
    }

    @Test
    fun createPerson() {
        RestAssured.defaultParser = Parser.JSON
        RestAssured.config
            .objectMapperConfig(ObjectMapperConfig().jackson2ObjectMapperFactory { _, _ ->
                ObjectMapper()
                    .registerModule(Jdk8Module())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            })

        val person = Person()
        person.firstname = "John"
        person.lastname = "Doe"

        given()
            .`when`()
            .body(person)
            .header("Content-Type", "application/json")
            .post("/create")
            .then()
            .statusCode(200)
            .body(both(startsWith("created: ID ")).and(not(endsWith("null"))))

        given()
            .`when`().get("/helloPerson")
            .then()
            .statusCode(200)
            .body(`is`("Hello John Doe"))
    }
}