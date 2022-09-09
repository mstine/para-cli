package com.mattstine.para.cmd

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
    name = "archive",
    aliases = ["ar"],
    description = ["Subcommands for managing Archives"],
    mixinStandardHelpOptions = true
)
class Archive {
    @Command(
        name = "list",
        aliases = ["l"],
        description = ["List Archives"],
        mixinStandardHelpOptions = true
    )
    fun list() {
    }

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["Remove Archives (no files deleted)"],
        mixinStandardHelpOptions = true
    )
    fun remove(
        @Option(
            names = ["-s", "--slug"],
            description = ["Archive slug"],
            required = true,
            paramLabel = "<SLUG>"
        )
        slug: String
    ) {
    }

    @Command(
        name = "open",
        aliases = ["o"],
        description = ["Opens Archive in configured PKM Tool"],
        mixinStandardHelpOptions = true
    )
    fun open(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Archive slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }

    @Command(
        name = "cd",
        description = ["Navigates to Archive directory"],
        mixinStandardHelpOptions = true
    )
    fun cd(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Archive slug",
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
        description = ["Opens Archive in configured IDE Tool"],
        mixinStandardHelpOptions = true
    )
    fun ide(
        @Option(
            names = ["-s", "--slug"],
            description = [
                "Archive slug",
            ],
            paramLabel = "<SLUG>",
            required = true
        )
        slug: String
    ) {
    }
}