package com.mattstine.para.cmd

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.nio.file.Path

@Command(
    name = "root",
    description = ["Subcommands for managing PARA Roots"],
    mixinStandardHelpOptions = true
)
class Root {
    @Command(
        name = "list",
        aliases = ["l"],
        description = ["List PARA Roots"],
        mixinStandardHelpOptions = true
    )
    fun list() {}

    @Command(
        name = "create",
        aliases = ["c"],
        description = ["Create PARA Root"],
        mixinStandardHelpOptions = true
    )
    fun create(
        @Option(
            names = ["-n", "--name"],
            description = ["PARA Root name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String,
        @Option(
            names = ["-p", "--path"],
            description = ["PARA Root path"],
            required = true,
            paramLabel = "<PATH>"
        )
        path: Path
    ) {}

    @Command(
        name = "remove",
        aliases = ["r"],
        description = ["Remove PARA Root (no files deleted)"],
        mixinStandardHelpOptions = true
    )
    fun remove(
        @Option(
            names = ["-n", "--name"],
            description = ["PARA Root name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}

    @Command(
        name = "default",
        aliases = ["d"],
        description = ["Make PARA Root default for new shells"],
        mixinStandardHelpOptions = true
    )
    fun default(
        @Option(
            names = ["-n", "--name"],
            description = ["PARA Root name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}

    @Command(
        name = "use",
        aliases = ["u"],
        description = ["Use PARA Root in current shell"],
        mixinStandardHelpOptions = true
    )
    fun use(
        @Option(
            names = ["-n", "--name"],
            description = ["PARA Root name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}

    @Command(
        name = "info",
        aliases = ["i"],
        description = ["Display PARA Root metadata"],
        mixinStandardHelpOptions = true
    )
    fun info(
        @Option(
            names = ["-n", "--name"],
            description = ["PARA Root name"],
            required = true,
            paramLabel = "<NAME>"
        )
        name: String
    ) {}
}