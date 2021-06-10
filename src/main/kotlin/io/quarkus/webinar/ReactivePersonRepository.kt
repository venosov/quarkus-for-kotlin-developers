package io.quarkus.webinar

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanionBase
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepositoryBase
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository : PanacheMongoRepositoryBase<Person, Long>


class Person: PanacheMongoEntityBase() {
    companion object: PanacheMongoCompanion<Person>

    @BsonId
    var id: ObjectId? = null
    var firstname: String? = null
    var lastname: String? = null
}
