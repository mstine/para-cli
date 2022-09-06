package com.mattstine.para.cmd

import picocli.CommandLine.Command

@Command(
    name = "project",
    aliases = ["p"],
    description = ["manages projects"]
)
class Project {

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["creates a new project"],
    )
    fun create() {}

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["opens project in configured note-taking tool"],
    )
    fun open() {}

    @Command(
        name = "cd",
        description = ["navigates to the project directory"],
    )
    fun cd() {}

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["opens project in configured IDE"],
    )
    fun ide() {}
}

