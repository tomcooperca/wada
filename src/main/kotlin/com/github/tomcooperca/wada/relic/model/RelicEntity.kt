package com.github.tomcooperca.wada.relic.model

import org.springframework.data.geo.Point

data class RelicEntity(val text: String, val location: Point) {
    var id: String = "NO_ID"
}