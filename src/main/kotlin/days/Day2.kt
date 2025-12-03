package days

@AdventOfCodePuzzle(
    name = "Gift Shop",
    url = "https://adventofcode.com/2025/day/2",
    date = Date(day = 2, year = 2025)
)
class Day2(private val input: String) : Puzzle {

    val ranges: List<LongRange> = input
        .split(",")
        .map {
            val (start, end) = it.split("-").map(String::toLong)
            start..end
        }

    override fun partOne(): Long = ranges.map { invalidIds(it) }.flatten().sum()

    override fun partTwo(): Long = ranges.map { invalidIds2(it) }.flatten()
        .also { println(it) }
        .sum()

    private fun invalidIds(it: LongRange): List<Long> {
        return (it.start..it.last)
            .filter { id ->
                val id1 = id.toString()
                id1.substring(0, id1.length / 2) == id1.substring(id1.length / 2)
            }
    }

    private fun invalidIds2(it: LongRange): List<Long> {
        return (it.start..it.last)
            .filter { id ->
                val stringId = id.toString()
                (1..stringId.length / 2)
                    .any { l ->
                        stringId.chunked(l).zipWithNext().all { (a, b) -> a == b }
                    }

            }
    }

}