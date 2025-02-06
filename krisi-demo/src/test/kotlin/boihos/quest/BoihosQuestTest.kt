package boihos.quest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.HttpStatusCode.Companion.OK

class BoihosQuestTest : FunSpec({
    test("application should start") {
        ktorTest { client ->
            val postResponse = client.post("/") {
                setBody("heyho")
            }

            postResponse.status shouldBe OK

            postResponse.bodyAsText() shouldBe "1"

            val getResponse = client.get("/1")

            getResponse.status shouldBe OK
            getResponse.bodyAsText() shouldBe """{"someString":"prefixke heyho suffixka","id":1}"""
        }
    }
})