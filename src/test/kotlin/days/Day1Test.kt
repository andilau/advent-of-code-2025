package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    val instructions = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun shouldReturnSumOfEmptyList() {
            assertThat(Day1(emptyList()).partOne()).isEqualTo(0)
        }

        @Test
        fun shouldPointAtZeroNTimes() {
            assertThat(Day1(instructions).partOne()).isEqualTo(3)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun shouldReturnProductOfEmptyList() {
            assertThat(Day1(emptyList()).partTwo()).isEqualTo(0)
        }

        @Test
        fun shouldReturnProductOfSimpleList() {
            assertThat(Day1(instructions).partTwo()).isEqualTo(6)
        }
    }
}