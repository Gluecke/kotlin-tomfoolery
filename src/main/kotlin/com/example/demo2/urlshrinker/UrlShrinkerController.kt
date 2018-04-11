package com.example.demo2.urlshrinker

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlShrinkerController(val shrinkerService: ShrinkerService) {

    @PostMapping("/shrinker/url")
    fun shrinkUrl(@RequestBody url: LongUrl): ShortUrl? {

        println("url to shorten ${url.longUrl}")

        return shrinkerService.shrink(url).also { println(url) }
    }

    data class ShortUrl(val kind: String, val id: String, val longUrl: String)

    data class LongUrl(val longUrl: String, val apiKey: String)
}