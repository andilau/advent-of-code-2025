package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day2Test {
    val ranges = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Adding up all the invalid IDs`() {
            assertThat(Day2(ranges).partOne()).isEqualTo(1227775554)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Adding up all the invalid IDs`() {
            assertThat(Day2(ranges).partTwo()).isEqualTo(4174379265)
        }
    }
}