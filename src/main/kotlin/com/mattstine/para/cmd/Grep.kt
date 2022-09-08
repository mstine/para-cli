package com.mattstine.para.cmd

import picocli.CommandLine.Command

@Command(
    name = "grep",
    aliases = ["g"],
    description = ["Regular Expression Search"]
)
class Grep : Runnable {
    override fun run() {
        TODO("Not yet implemented")
    }
}