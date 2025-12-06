package days

@AdventOfCodePuzzle(
    name = "Trash Compactor",
    url = "https://adventofcode.com/2025/day/6",
    date = Date(day = 6, year = 2025)
)
class Day6(val input: List<String>) : Puzzle {

    val homework = input.map { it.trim().split(Regex("\\s+")) }
    val pos: List<Int> =
        input.last().mapIndexedNotNull { ix, s -> if (s != ' ') ix else null } + input.first().lastIndex.plus(2)
    val ranges = pos.windowed(2) { (a, b) -> IntRange(a, b - 2) }

    override fun partOne(): Long {
        return homework.first().indices.sumOf { ix ->
            val ops = homework.dropLast(1).map { it[ix].toLong() }
            val op = homework.last()[ix]
            when (op) {
                "*" -> ops.reduce { acc, i -> acc * i }
                "+" -> ops.reduce { acc, i -> acc + i }
                else -> throw IllegalArgumentException("Unknown operant ${op}")
            }
        }
    }

    override fun partTwo(): Long {
        return ranges.reversed().sumOf { range ->
            val op: Char = input.last()[range.first]

            val ops: List<Long> = range
                .map { ix ->
                    input.dropLast(1)
                        .map { line -> line[ix] }
                        .joinToString("")
                        .trim()
                        .toLong()
                }
            when (op) {
                '*' -> ops.reduce { acc, i -> acc * i }
                '+' -> ops.reduce { acc, i -> acc + i }
                else -> throw IllegalArgumentException("Unknown operant ${op}")
            }
        }
    }

}