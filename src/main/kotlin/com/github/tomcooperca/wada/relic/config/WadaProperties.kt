package com.github.tomcooperca.wada.relic.config

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("wada")
class WadaProperties(val databaseName: String = "relic", val collectionName: String = "messages") {}