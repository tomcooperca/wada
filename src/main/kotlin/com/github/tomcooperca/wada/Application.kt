package com.github.tomcooperca.wada

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.github.tomcooperca.wada")
                .mainClass(Application.javaClass)
                .start()
    }
}