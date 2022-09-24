package com.mattstine.para.root

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import java.nio.file.Path

class RootServiceTest {

    @Test
    fun `initial root list should be empty`() {
        assertThat(RootService().list()).isEmpty()
    }

    @Test
    fun `creating a root results in a one item list`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThat(this.list()).size().isEqualTo(1)
        }
    }

    @Test
    fun `a created root can be found`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            this.find("root1")?.apply {
                assertThat(path).hasFileName("path1")
            }
        }
    }

    @Test
    fun `the same root cannot be created twice`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThatExceptionOfType(RootExistsException::class.java)
                .isThrownBy {
                    this.create("root1", Path.of("path1"))
                }
        }
    }
}