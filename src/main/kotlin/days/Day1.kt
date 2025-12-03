package days

@AdventOfCodePuzzle(
    name = "Secret Entrance",
    url = "https://adventofcode.com/2025/day/1",
    date = Date(day = 1, year = 2025)
)
class Day1(private val input: List<String>) : Puzzle {

    override fun partOne(): Int {
        return input
            .map { it[0] to it.substring(1).toInt() }
            .scan(50) { acc, (turn, value) ->
                when (turn) {
                    'L' -> (acc - value + 100) % 100
                    'R' -> (acc + value) % 100
                    else -> acc
                }
            }.count { it == 0 }
    }

    override fun partTwo(): Int = input
            .map { it[0] to it.substring(1).toInt() }
            .fold(listOf(50)) { acc, (turn, value) ->
                val last = acc.last()
                val value1: List<Int> = when (turn) {
                    'L' -> acc + (last - 1).downTo(last - value)
                    'R' -> acc + ((last + 1)..(last + value))
                    else -> acc
                }
                value1
            }.count { it % 100 == 0 }

}