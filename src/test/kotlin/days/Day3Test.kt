package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day3Test {
    val banks = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
    """.trimIndent().lines()
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `total output joltage is the sum of the maximum joltage from each bank`() {
            assertThat(Day3(banks).partOne()).isEqualTo(357)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Adding up all the invalid IDs`() {
            assertThat(Day3(banks).partTwo()).isEqualTo(3121910778619)
        }
    }
}