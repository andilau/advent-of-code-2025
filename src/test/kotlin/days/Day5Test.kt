package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day5Test {
    val input = """
        3-5
        10-14
        16-20
        12-18

        1
        5
        8
        11
        17
        32
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `How many available ingredient IDs are fresh`() {
            assertThat(Day5(input).partOne()).isEqualTo(3)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `How many ingredient IDs are considered to be fresh according to the fresh ingredient ID ranges`() {
            assertThat(Day5(input).partTwo()).isEqualTo(14)
        }
    }
}