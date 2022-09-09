package com.mattstine.para.cmd

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.time.LocalDate
import java.util.*

@Command(
    name = "resource",
    aliases = ["r"],
    description = ["Subcommands for managing Resources"],
    mixinStandardHelpOptions = true
)
class Resource {

    @Command(
        name = "list",
        aliases = ["l"],
        description = ["List Resources"],
        mixinStandardHelpOptions = true
    )
    fun list() {
    }

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["Creates new Resource"],
        mixinStandardHelpOptions = true
    )
    fun create(
        @Option(
            names = ["-n", "--name"],
            description = ["Resource name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String,
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Resource slug",
                "Must be unique within PARA Root",
                "Default will be <NAME> in lower-snake-case"
            ],
            paramLabel = "<SLUG>"
        )
        slug: Optional<String>
    ) {
    }

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["Remove Resource (no files deleted)"],
        mixinStandardHelpOptions = true
    )
    fun remove(
        @Option(
            names = ["-s", "--slug"],
            description = ["Resource slug"],
            required = true,
            paramLabel = "<SLUG>"
        )
        slug: String
    ) {
    }

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["Opens Resource in configured PKM Tool"],
        mixinStandardHelpOptions = true
    )
    fun open(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Resource slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }

    @Command(
        name = "cd",
        description = ["Navigates to Resource directory"],
        mixinStandardHelpOptions = true
    )
    fun cd(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Resource slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["Opens Resource in configured IDE Tool"],
        mixinStandardHelpOptions = true
    )
    fun ide(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Resource slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }
}