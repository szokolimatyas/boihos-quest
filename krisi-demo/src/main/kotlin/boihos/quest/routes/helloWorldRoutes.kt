package boihos.quest.routes

import boihos.quest.service.HelloWorldService
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.helloWorldRoutes() {
    routing {
        val service by inject<HelloWorldService>()
        post("/") {
            call.respond(
                service.respondHello(call.receiveText())
            )
        }
        get("/{id}") {
            val id = call.pathParameters["id"]?.toLong() ?: throw BadRequestException("bad request")
            call.respond(
                service.getById(id) ?: throw BadRequestException("id not found")
            )
        }
    }
}