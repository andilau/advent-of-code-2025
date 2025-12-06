import days.Day1
import days.Day2
import days.Day4
import days.Day5
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import util.InputReader

@DisplayName("Solutions")
class SolutionsTest {
    @TestFactory
    fun testAdventOfCode() = listOf(
        Day1(InputReader.getInputAsList(1)) to Pair(1165, 6496),
        Day2(InputReader.getInputAsString(2)) to Pair(64215794229L, 85513235135L),
        Day4(InputReader.getInputAsList(4)) to Pair(1367, 0),
        Day5(InputReader.getInputAsList(5)) to Pair(737, 357485433193284L)
    )
        .map { (day, answers) ->
            DynamicTest.dynamicTest("${day.javaClass.simpleName} -> ${answers.first} / ${answers.second}") {
                assertThat(day.partOne()).isEqualTo(answers.first)
                assertThat(day.partTwo()).isEqualTo(answers.second)
            }
        }
}