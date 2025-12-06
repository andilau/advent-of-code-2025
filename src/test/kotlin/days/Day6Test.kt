package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day6Test {
    val homework = listOf(
        "123 328  51 64 ",
        " 45 64  387 23 ",
        "  6 98  215 314",
        "*   +   *   +  "
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `What is the grand total found by adding together all of the answers to the individual problems`() {
            assertThat(Day6(homework).partOne()).isEqualTo(4277556)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `What is the grand total found by adding together all of the answers to the individual problems`() {
            assertThat(Day6(homework).partTwo()).isEqualTo(3263827)
        }
    }
}