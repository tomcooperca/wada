package com.github.tomcooperca.wada.relic.web

import com.github.tomcooperca.wada.relic.model.RelicEntity
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller("/messages")
class RelicController (private val relicHandler: RelicHandler) {

//    fun routes(relicHandler: RelicHandler): RouterFunction<ServerResponse> = router {
//        "/messages".nest {
//            GET("/", relicHandler::listRelics)
//            GET("/{id}", relicHandler::getRelic)
//            GET("/{lat}/{lon}/{distance}", relicHandler::listRelicsNearLocation)
//            GET("/{id}/{distance}", relicHandler::listRelicsNearRelic)
//            POST("/", relicHandler::createRelic)
//            DELETE("/{id}", relicHandler::deleteRelic)
//        }
//    }

    @Get("/", produces = [MediaType.APPLICATION_JSON])
    fun listAll(): HttpResponse<Single<List<RelicEntity>>> {
        return HttpResponse.ok(relicHandler.listRelics())

    }
}