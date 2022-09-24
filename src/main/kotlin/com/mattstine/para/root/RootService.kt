package com.mattstine.para.root

import java.nio.file.Path

class RootService {
    private val repository = mutableListOf<Root>()

    fun list() = repository.toList()

    fun create(name: String, path: Path) =
        this.find(name).let {
            if (it != null) {
               throw RootExistsException(it)
            } else {
                repository += Root(name, path)
            }
        }

    fun find(name: String): Root? = repository
        .singleOrNull { it.name == name }
}

data class Root(
    val name: String,
    val path: Path
)

data class RootExistsException(
    val root: Root
) : Exception()