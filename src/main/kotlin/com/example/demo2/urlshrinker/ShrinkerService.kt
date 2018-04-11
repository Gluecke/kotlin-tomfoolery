package com.example.demo2.urlshrinker

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ShrinkerService {
    fun shrink(url: UrlShrinkerController.LongUrl): UrlShrinkerController.ShortUrl? {

        val restTemplate = RestTemplate()

        println("this is a change")

        val res = restTemplate.postForEntity("https://www.googleapis.com/urlshortener/v1/url?key=${url.apiKey}",
                url,
                UrlShrinkerController.ShortUrl::class.java)

        return res.body

    }

}
