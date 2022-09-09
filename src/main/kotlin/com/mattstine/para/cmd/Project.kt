package com.mattstine.para.cmd

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.time.LocalDate
import java.util.*

@Command(
    name = "project",
    aliases = ["p"],
    description = ["Subcommands for managing Projects"],
    mixinStandardHelpOptions = true
)
class Project {

    @Command(
        name = "list",
        aliases = ["l"],
        description = ["List Projects"],
        mixinStandardHelpOptions = true
    )
    fun list() {}

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["Creates new Project"],
        mixinStandardHelpOptions = true
    )
    fun create(
        @Option(
            names = ["-n", "--name"],
            description = ["Project name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String,
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Project slug",
                "Must be unique within PARA Root",
                "Default will be <NAME> in lower-snake-case"
                          ],
            paramLabel = "<SLUG>"
        )
        slug: Optional<String>,
        @Option(
            names = ["-d", "--review-date"],
            description = ["Project review date"],
            required = true,
            paramLabel = "<yyyy-MM-dd>"
        )
        reviewDate: LocalDate,
        @Option(
            names = ["-g", "--goals"],
            description = [
                "Project goal(s)",
                "(Optional)"
                          ],
            paramLabel = "<GOAL>",
            split = ","
        )
        goal: List<String>?
    ) {}

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["Remove Project (no files deleted)"],
        mixinStandardHelpOptions = true
    )
    fun remove(
        @Option(
            names = ["-s", "--slug"],
            description = ["Project slug"],
            required = true,
            paramLabel = "<SLUG>"
        )
        slug: String
    ) {}

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["Opens Project in configured PKM Tool"],
        mixinStandardHelpOptions = true
    )
    fun open(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Project slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {}

    @Command(
        name = "cd",
        description = ["Navigates to Project directory"],
        mixinStandardHelpOptions = true
    )
    fun cd(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Project slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {}

    @Command(
        name = "ide",
        aliases = ["i"],
        description = ["Opens Project in configured IDE Tool"],
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
    ) {}
}

