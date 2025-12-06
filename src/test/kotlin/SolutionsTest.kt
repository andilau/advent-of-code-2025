import days.*
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
        Day2(InputReader.getInputAsString(2)) to Pair(64215794229, 85513235135),
        Day3(InputReader.getInputAsList(3)) to Pair(16858L, 167549941654721),
        Day4(InputReader.getInputAsList(4)) to Pair(1367, 9144),
        Day5(InputReader.getInputAsList(5)) to Pair(737, 357485433193284),
        Day6(InputReader.getInputAsList(6)) to Pair(5361735137219, 11744693538946)
    )
        .map { (day, answers) ->
            DynamicTest.dynamicTest("${day.javaClass.simpleName} -> ${answers.first} / ${answers.second}") {
                assertThat(day.partOne()).isEqualTo(answers.first)
                assertThat(day.partTwo()).isEqualTo(answers.second)
            }
        }
}