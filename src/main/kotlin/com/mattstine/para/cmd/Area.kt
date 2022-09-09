package com.mattstine.para.cmd

import picocli.CommandLine.*
import java.time.LocalDate
import java.util.*

@Command(
    name = "area",
    aliases = ["a"],
    description = ["Subcommands for managing Areas"],
    mixinStandardHelpOptions = true
)
class Area {

    @Command(
        name = "list",
        aliases = ["l"],
        description = ["List Areas"],
        mixinStandardHelpOptions = true
    )
    fun list() {
    }

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["Creates new Area"],
        mixinStandardHelpOptions = true
    )
    fun create(
        @Option(
            names = ["-n", "--name"],
            description = ["Area name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String,
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Area slug",
                "Must be unique within PARA Root",
                "Default will be <NAME> in lower-snake-case"
            ],
            paramLabel = "<SLUG>"
        )
        slug: Optional<String>,
        @Option(
            names = ["-d", "--review-date"],
            description = ["Area review date"],
            required = true,
            paramLabel = "<yyyy-MM-dd>"
        )
        reviewDate: LocalDate,
        @Option(
            names = ["-q", "--quality-standards"],
            description = [
                "Quality standard(s)",
                "(Optional)"
            ],
            paramLabel = "<QUALITY STANDARD>",
            split = ","
        )
        qualityStandards: List<String>?
    ) {
    }

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["Remove Area (no files deleted)"],
        mixinStandardHelpOptions = true
    )
    fun remove(
        @Option(
            names = ["-s", "--slug"],
            description = ["Area slug"],
            required = true,
            paramLabel = "<SLUG>"
        )
        slug: String
    ) {
    }

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["Opens Area in configured PKM Tool"],
        mixinStandardHelpOptions = true
    )
    fun open(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Area slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }

    @Command(
        name = "cd",
        description = ["Navigates to Area directory"],
        mixinStandardHelpOptions = true
    )
    fun cd(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Area slug",
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
        description = ["Opens Area in configured IDE Tool"],
        mixinStandardHelpOptions = true
    )
    fun ide(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Project slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }
}