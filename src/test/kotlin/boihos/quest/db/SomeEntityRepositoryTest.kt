package boihos.quest.db

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class SomeEntityRepositoryTest : FunSpec({
    lateinit var repo: SomeEntityRepository

    val dbListener = DatabaseListener(
        beforeTestBlock = { _, db ->
            repo = SomeEntityRepository(db)
        }
    ).also {
        listeners(it)
    }
    test("insert should work") {
        val id = dbListener.withTransaction {
            repo.insert(SomeEntity("someString")).id
        }!!

        dbListener.withTransaction {
            val results = repo.find(id)

            results shouldNotBe null

            results!!.someString shouldBe "someString"
        }
    }

    test("multiple should work") {
        dbListener.withTransaction {
            repo.insert(SomeEntity("someString1"))
            repo.insert(SomeEntity("someString2"))
            repo.insert(SomeEntity("someString3"))
            repo.insert(SomeEntity("someString4"))
        }

        dbListener.withTransaction {
            val results = repo.findAll()

            results.size shouldBe 4
        }
    }
})