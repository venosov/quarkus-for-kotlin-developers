package io.quarkus.webinar

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/")
class GreetingResource {
    @Inject
    lateinit var personRepository: PersonRepository

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun hello(): String {
        return "Hello Live Reload"
    }

    @GET
    @Path("/newguy")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun newguy(): String {
        return "Hello New Guy"
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    fun create(person: Person): Response {
        person.persist()
        val created = Person.findAll().firstResult()
        return Response.ok("created:  ID ${created?.id}").build()
    }

    @GET
    @Path("/helloPerson")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloPerson(): String {
        val person = Person.findAll().firstResult()
        return "Hello ${person?.firstname} ${person?.lastname}"
    }
}