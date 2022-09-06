package com.mattstine.para.cmd

import picocli.CommandLine.Command

@Command(
    name = "archive",
    aliases = ["ar"],
    description = ["manages archives"]
)
class Archive {
    @Command(
        name = "open",
        aliases = ["o"],
        description = ["opens archive in configured note-taking tool"],
    )
    fun open() {}

    @Command(
        name = "cd",
        description = ["navigates to the archive directory"],
    )
    fun cd() {}

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["opens archive in configured IDE"],
    )
    fun ide() {}
}