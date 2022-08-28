package io.quarkus.webinar

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
//import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.codecs.pojo.annotations.BsonId
//import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepositoryBase
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
// class PersonRepository : PanacheMongoRepositoryBase<Person, Long>
//class PersonRepository : PanacheMongoRepository<Person>

//class Person {
//    @BsonId
//    var id: ObjectId? = null
//    lateinit var firstname: String
//    lateinit var lastname: String
//}

class Person: PanacheMongoEntityBase() {
    companion object: PanacheMongoCompanion<Person>

    @BsonId
    var id: ObjectId? = null
    lateinit var firstname: String
    lateinit var lastname: String
}
