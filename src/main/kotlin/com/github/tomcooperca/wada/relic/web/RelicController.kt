package com.github.tomcooperca.wada.relic.web

import io.micronaut.http.annotation.Controller

@Controller("/messages")
class RelicController {

    fun routes(relicHandler: RelicHandler): RouterFunction<ServerResponse> = router {
//        "/messages".nest {
//            GET("/", relicHandler::listRelics)
//            GET("/{id}", relicHandler::getRelic)
//            GET("/{lat}/{lon}/{distance}", relicHandler::listRelicsNearLocation)
//            GET("/{id}/{distance}", relicHandler::listRelicsNearRelic)
//            POST("/", relicHandler::createRelic)
//            DELETE("/{id}", relicHandler::deleteRelic)
//        }
    }

    fun listAll(): {}
}