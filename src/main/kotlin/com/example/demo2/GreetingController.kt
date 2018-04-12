package com.example.demo2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/greetings")
    fun greetings(@RequestParam(value = "name") name: String?): List<Greeting> {

        val statement = name?.toUpperCase() ?: "world".toUpperCase()

        val greetings = listOf("Bonjour", "Hola", "Hallo", "Ciao", "Hello", "Salaam", "Zdras-Tvuy-Te")

        val random = Random()

        return greetings.filter { random.nextBoolean() }
                .map { g -> Greeting(counter.incrementAndGet(), g.plus(", $statement")) }
    }

    @GetMapping("/greetings/{season}")
    fun seasonsGreetings(@PathVariable(value = "season") season: String,
                         @RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Happy $season $name!")
    }

}