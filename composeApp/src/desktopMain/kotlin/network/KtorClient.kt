package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.*
import model.dao.DesktopDao
import model.data.entity.Character
import model.data.entity.Episode
object KtorClient {
    private val client = HttpClient(OkHttp) {
        install(Logging)
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }


    suspend fun getCharacterById(id: Int) =
        client.get("https://rickandmortyapi.com/api/character/$id").body<Character>()

    suspend fun getEpisodeByUrl(url: String, dao: DesktopDao) : Episode{
        dao.getEpisodeByUrl(url)?.let { episode ->
            return episode
        }
        val episode = client.get(url).body<Episode>()
        dao.insertEpisode(episode)
        return episode
    }

}

