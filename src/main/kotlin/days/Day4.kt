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

    override fun partTwo(): Int {
        val nextFunction: (Set<Point>) -> Set<Point> = { rolls ->
            rolls.filter { roll -> roll.eightNeighbors().count { rolls.contains(it) } >= 4 }.toSet()
        }
        val finalRound: Set<Point> = generateSequence(paperRolls, nextFunction)
            .windowed(2)
            .takeWhile { (a, b) -> a.size != b.size }
            .map { it[1] }
            .last()
        return paperRolls.size - finalRound.size
    }

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