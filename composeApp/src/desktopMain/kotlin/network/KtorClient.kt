package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.*
import network.dto.Character

object KtorClient {
    private val client = HttpClient(OkHttp) {
        install(Logging)
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun test() = client.get("https://rickandmortyapi.com/api/character/118").body<Character>()

}