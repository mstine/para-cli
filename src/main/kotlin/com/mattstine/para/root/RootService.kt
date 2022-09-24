package com.mattstine.para.root

import arrow.core.Either
import java.nio.file.Path

class RootService {
    private val repository = mutableListOf<Root>()

    fun list() = repository.toList()

    fun create(name: String, path: Path): Either<RootError.Exists, Root> =
        this.find(name).let { found ->
            if (found != null) {
                Either.Left(RootError.Exists)
            } else {
                Root(name, path).let { new ->
                    repository += new
                    Either.Right(new)
                }
            }
        }

    fun find(name: String): Root? = repository
        .singleOrNull { it.name == name }
}

data class Root(
    val name: String,
    val path: Path
)

sealed class RootError {
    object Exists : RootError()
}