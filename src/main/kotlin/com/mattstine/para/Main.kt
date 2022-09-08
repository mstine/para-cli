package com.mattstine.para

import com.mattstine.para.cmd.*
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.HelpCommand
import kotlin.system.exitProcess

@Command(
    name = "para",
    header = [
        "PARA CLI - A Shell for Your Second Brain!",
        "-----------------------------------------"
             ],
    footer = [
        "---------------------------------",
        "Copyright (C) 2022 Matthew Stine."
             ],
    mixinStandardHelpOptions = true,
    version = ["0.1.0"],
    subcommands = [
        Root::class,
        Project::class,
        Area::class,
        Resource::class,
        Archive::class,
        Grep::class,
        HelpCommand::class
    ]
)
class Main

fun main(args: Array<String>): Unit = exitProcess(CommandLine(Main()).execute(*args))