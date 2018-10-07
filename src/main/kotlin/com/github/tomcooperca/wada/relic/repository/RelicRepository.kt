package com.github.tomcooperca.wada.relic.repository

import com.github.tomcooperca.wada.relic.model.RelicEntity
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point

//interface RelicRepository : ReactiveMongoRepository<RelicEntity, String> {
//    fun findByPointNear(location: Point, distance: Distance): Flux<RelicEntity>
//}