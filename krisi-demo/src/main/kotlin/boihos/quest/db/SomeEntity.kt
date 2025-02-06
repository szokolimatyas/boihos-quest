package boihos.quest.db

import kotlinx.serialization.Serializable
import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperEntityDef
import org.komapper.annotation.KomapperId

@Serializable
data class SomeEntity(
    val someString: String,
    val id: Long? = null
)


@KomapperEntityDef(SomeEntity::class)
data class SomeEntityDef(
    @KomapperId
    @KomapperAutoIncrement
    val id: Nothing,
    val someString: Nothing
)