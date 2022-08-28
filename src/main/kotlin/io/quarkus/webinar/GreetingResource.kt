package io.quarkus.webinar

//import javax.inject.Inject
//import kotlinx.coroutines.delay
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/")
class GreetingResource {
//    @Inject
//    lateinit var personRepository: PersonRepository

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun hello(): String {
//        delay(5000)
        return "Hello RESTEasy Reactive"
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    fun create(person: Person): Response {
//        personRepository.persist(person)
//        val created = personRepository.findAll().firstResult()
        person.persist()
        val created = Person.findAll().firstResult()
        return Response.ok("created: ID ${created?.id}").build()
    }

    @GET
    @Path("/helloPerson")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloPerson(): String {
//        val person = personRepository.findAll().firstResult()
        val person = Person.findAll().firstResult()
        return "Hello ${person?.firstname} ${person?.lastname}"
    }
}
