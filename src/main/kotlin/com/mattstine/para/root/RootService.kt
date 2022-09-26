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
        repository.indexOfFirst { it.name == name }.let { indexOfNewDefault ->
            if (indexOfNewDefault < 0) {
                Either.Left(RootError.NotFound)
            } else {
                findIndexOfCurrentDefault().orNull()?.let {
                    repository[it] = repository[it].copy(default = false)
                }
                repository[indexOfNewDefault] = repository[indexOfNewDefault].copy(default = true)
                Either.Right(None)
            }
        }

    private fun findByPath(path: Path): Root? = repository
        .singleOrNull { it.path.fileName == path.fileName }

    private fun findIndexOfCurrentDefault(): Either<None, Int> =
        repository.indexOfFirst { it.default }.let {
            when {
                it < 0 -> Either.Left(None)
                else -> Either.Right(it)
            }
        }
}

data class Root(
    val name: String,
    val path: Path,
    val default: Boolean = false
)


sealed class RootError {
    object Exists : RootError()
    object PathExists : RootError()
    object NotFound : RootError()
}