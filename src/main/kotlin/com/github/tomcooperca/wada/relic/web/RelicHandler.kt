package com.github.tomcooperca.wada.relic.web

import com.github.tomcooperca.wada.relic.config.WadaProperties
import com.github.tomcooperca.wada.relic.model.RelicEntity
import com.mongodb.reactivestreams.client.MongoClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.reactivex.Flowable
import io.reactivex.Single

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Metrics.KILOMETERS
import org.springframework.data.geo.Point
import java.net.URI
import java.util.*
import javax.inject.Singleton


@Singleton
class RelicHandler(private val mongoClient: MongoClient, private val properties: WadaProperties) {


    fun listRelics(): Single<List<RelicEntity>> {
        return Flowable.fromPublisher(mongoClient
                .getDatabase(properties.databaseName)
                .getCollection(properties.collectionName, RelicEntity::class.java)
                .find())
                .toList()
    }

//    fun listRelicsNearLocation(request: ServerRequest): Mono<ServerResponse> {
//        val location: Point = getPointFromPathVars(request)
//        val distance: Distance = getDistanceFromPathVar(request)
//        return ok()
//                .contentType(APPLICATION_JSON)
//                .body(BodyInserters.fromPublisher(
//                        relicRepository.findByPointNear(location, distance),
//                        RelicEntity::class.java))
//    }
//
//    fun listRelicsNearRelic(request: ServerRequest): Mono<ServerResponse> {
//        val distance: Distance = getDistanceFromPathVar(request)
//        return relicRepository.findById(request.pathVariable("id")).flatMap { message ->
//            ok()
//                    .contentType(APPLICATION_JSON)
//                    .body(BodyInserters.fromPublisher(
//                            relicRepository.findByPointNear(message.locationToPoint(), distance),
//                            RelicEntity::class.java))
//        }
//                .switchIfEmpty(notFound().build())
//    }
//
//    fun getRelic(request: ServerRequest): Mono<ServerResponse> {
//        return relicRepository.findById(request.pathVariable("id")).flatMap { message ->
//            ok().contentType(APPLICATION_JSON).body(BodyInserters.fromObject(message))
//        }
//                .switchIfEmpty(notFound().build())
//    }
//
//    fun createRelic(request: ServerRequest): Mono<ServerResponse> {
//        return request.bodyToMono<RelicEntity>().flatMap { message ->
//            val id = UUID.randomUUID().toString()
//            message.id = id
//            message.point = message.locationToPoint()
//            relicRepository.save(message).flatMap { created ->
//                created(URI.create("${request.uri()}${created.id}")).build()
//            }
//        }
//    }
//
//    fun deleteRelic(request: ServerRequest): Mono<ServerResponse> {
//        return relicRepository.findById(request.pathVariable("id")).flatMap { message ->
//            noContent().build(relicRepository.deleteById(message.id))
//        }
//                .switchIfEmpty(notFound().build())
//    }
//
//    private fun getPointFromPathVars(request: ServerRequest): Point {
//        return Point(request.pathVariable("lon").toDouble(), request.pathVariable("lat").toDouble())
//    }
//
//    private fun getDistanceFromPathVar(request: ServerRequest): Distance {
//        return Distance(request.pathVariable("distance").toDouble(), KILOMETERS)
//    }
}