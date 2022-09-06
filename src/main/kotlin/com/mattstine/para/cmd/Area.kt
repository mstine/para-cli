package com.mattstine.para.cmd

import picocli.CommandLine.Command

@Command(
    name = "area",
    aliases = ["a"],
    description = ["manages Areas"],
)
class Area {

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["creates a new area"],
    )
    fun create() {}

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["opens area in configured note-taking tool"],
    )
    fun open() {}

    @Command(
        name = "cd",
        description = ["navigates to the area directory"],
    )
    fun cd() {}

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["opens area in configured IDE"],
    )
    fun ide() {}
}