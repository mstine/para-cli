package com.mattstine.para.cmd

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.nio.file.Path

@Command(
    name = "root",
    description = ["manage PARA root locations"],
)
class Root {
    @Command(
        name = "list",
        aliases = ["l"],
        description = ["list PARA root locations"],
    )
    fun list() {}

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["create new PARA root location"],
    )
    fun create(
        @Option(
            names = ["-n", "--name"],
            description = ["the PARA Root's name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String,
        @Option(
            names = ["-p", "--path"],
            description = ["the PARA Root's path"],
            required = true,
            paramLabel = "<PATH>"
        )
        path: Path
    ) {}

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["remove PARA root location (no files deleted)"],
    )
    fun remove(
        @Option(
            names = ["-n", "--name"],
            description = ["the PARA Root's name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}

    @Command(
        name = "default",
        aliases = ["d"],
        description = ["set this PARA root to be the default for new shells"],
    )
    fun default(
        @Option(
            names = ["-n", "--name"],
            description = ["the PARA Root's name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}

    @Command(
        name = "use",
        aliases = ["u"],
        description = ["use this PARA root in this shell"],
    )
    fun use(
        @Option(
            names = ["-n", "--name"],
            description = ["the PARA Root's name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}
}