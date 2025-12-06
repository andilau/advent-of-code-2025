package days

@AdventOfCodePuzzle(
    name = "Printing Department",
    url = "https://adventofcode.com/2025/day/4",
    date = Date(day = 4, year = 2025)
)
class Day4(val input: List<String>) : Puzzle {

    val paperRolls: Set<Point> = input.flatMapIndexed { y, line ->
        line.mapIndexedNotNull { x, c -> if (c == '@') Point(x, y) else null }
    }.toSet()

    override fun partOne(): Int {
        return paperRolls.count { roll ->
            roll.eightNeighbors().count { paperRolls.contains(it) } < 4
        }
    }

    override fun partTwo(): Long = 0

    data class Point(val x: Int, val y: Int) {

        fun eightNeighbors(): Set<Point> =
            setOf(
                this.copy(x = x + 1, y = y + 1),
                this.copy(x = x + 1, y = y),
                this.copy(x = x + 1, y = y - 1),
                this.copy(x = x, y = y + 1),
                this.copy(x = x, y = y - 1),
                this.copy(x = x - 1, y = y + 1),
                this.copy(x = x - 1, y = y),
                this.copy(x = x - 1, y = y - 1),
            )
    }
}