package com.mattstine.para.cmd

import picocli.CommandLine.Command

@Command(
    name = "resource",
    aliases = ["r"],
    description = ["manages resources"],
)
class Resource {
    @Command(
        name = "create",
        aliases = ["c"],
        description = ["creates a new resource"],
    )
    fun create() {}

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["opens resource in configured note-taking tool"],
    )
    fun open() {}

    @Command(
        name = "cd",
        description = ["navigates to the resource directory"],
    )
    fun cd() {}

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["opens resource in configured IDE"],
    )
    fun ide() {}
}