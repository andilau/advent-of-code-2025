package days

@AdventOfCodePuzzle(
    name = "Lobby",
    url = "https://adventofcode.com/2025/day/3",
    date = Date(day = 3, year = 2025)
)
class Day3(input: List<String>) : Puzzle {

    val banks: List<CharArray> = input.map { it.toCharArray() }

    override fun partOne(): Long = banks.sumOf { joltageOf(it, 2) }

    override fun partTwo(): Long = banks.sumOf { joltageOf(it, 12) }

    private fun joltageOf(bank: CharArray, pick: Int): Long {
        val digits: List<Int> = bank.map { it.digitToInt() }

        var joltage = 0L
        var pickFrom: IntRange = 0..(bank.size - pick)

        repeat(pick) {
            val slice = digits.slice(pickFrom)
            val max = slice.maxBy { it }
            val pos = slice.indexOf(max)
            pickFrom = IntRange(pickFrom.first + pos + 1, pickFrom.last + 1)
            joltage = joltage * 10 + max
        }
        return joltage
    }


}