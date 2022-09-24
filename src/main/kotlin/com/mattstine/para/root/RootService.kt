package com.mattstine.para.root

import arrow.core.Either
import arrow.core.None
import java.nio.file.Path

class RootService {
    private val repository = mutableListOf<Root>()

    fun list() = repository.toList()

    fun create(name: String, path: Path): Either<RootError, Root> =
        if (find(name) != null) {
            Either.Left(RootError.Exists)
        } else if (findByPath(path) != null) {
            Either.Left(RootError.PathExists)
        } else {
            Root(name, path).let { new ->
                repository += new
                Either.Right(new)
            }
        }

    fun find(name: String): Root? = repository
        .singleOrNull { it.name == name }

    fun remove(name: String): Either<RootError.NotFound, None> =
        repository.removeIf { it.name == name }
            .let {
                when (it) {
                    true -> Either.Right(None)
                    false -> Either.Left(RootError.NotFound)
                }
            }

    fun default(name: String): Either<RootError.NotFound, None> =
        this.find(name).let {
            if (it != null) {
                clearDefaultRoot()
                it.default = true
                Either.Right(None)
            } else {
                Either.Left(RootError.NotFound)
            }
        }

    private fun clearDefaultRoot() {
        repository.forEach { root ->
            root.default = false
        }
    }

    private fun findByPath(path: Path): Root? = repository
        .singleOrNull { it.path.fileName == path.fileName }
}

data class Root(
    val name: String,
    val path: Path,
    var default: Boolean = false
)



sealed class RootError {
    object Exists : RootError()
    object PathExists : RootError()
    object NotFound : RootError()
}