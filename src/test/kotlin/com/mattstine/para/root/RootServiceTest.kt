package com.mattstine.para.root

import org.assertj.core.api.Assertions.assertThat
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
            this.create("root1", Path.of("path1")).let { a ->
                this.find("root1")?.apply {
                    assertThat(a.orNull()).isEqualTo(this)
                }
            }
        }
    }

    @Test
    fun `the same root cannot be created twice`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThat(this.create("root1", Path.of("path1")).isLeft()).isTrue
        }
    }

    @Test
    fun `the same root path cannot be referenced twice`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThat(this.create("root2", Path.of("path1")).isLeft()).isTrue
        }
    }

    @Test
    fun `a root can be removed`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThat(this.remove("root1").isRight()).isTrue
        }
    }

    @Test
    fun `a missing root cannot be removed`() {
        with(RootService()) {
            assertThat(this.remove("root1").isLeft()).isTrue
        }
    }

    @Test
    fun `a root can be made the default`() {
        with(RootService()) {
            this.create("root1", Path.of("path1"))
            assertThat(this.default("root1").isRight()).isTrue
            assertThat(this.find("root1")?.default).isTrue
        }
    }

    @Test
    fun `a missing root cannot be made default`() {
        with(RootService()) {
            assertThat(this.default("root1").isLeft()).isTrue
        }
    }

    @Test
    fun `only one root can be default`() {
        with(RootService()) {
            val root1 = this.create("root1", Path.of("path1"))
            this.default("root1")

            val root2 = this.create("root2", Path.of("path2"))
            this.default("root2")

            assertThat(root1.orNull()?.default).isFalse
            assertThat(root2.orNull()?.default).isTrue
        }
    }
}