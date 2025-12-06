package days

@AdventOfCodePuzzle(
    name = "Cafeteria",
    url = "https://adventofcode.com/2025/day/5",
    date = Date(day = 5, year = 2025)
)
class Day5(input: List<String>) : Puzzle {

    val ranges: List<LongRange> =
        input.takeWhile { it.isNotEmpty() }.map { it.split("-").map { it.toLong() }.let { LongRange(it[0], it[1]) } }

    val ingredientIds: List<Long> = input.dropWhile { it.isNotEmpty() }
        .drop(1)
        .map { it.toLong() }

    override fun partOne(): Int = ingredientIds.count { id -> ranges.any { id in it } }

    override fun partTwo(): Long = mergeRanges(ranges).sumOf { it.last - it.first + 1 }

    fun mergeRanges(ranges: Iterable<LongRange>): List<LongRange> {
        val sorted = ranges.sortedBy { it.first }
        val result = mutableListOf<LongRange>()

        var current = sorted.first()
        for (r in sorted.drop(1)) {
            if (r.first <= current.last + 1) {
                val endInclusive = maxOf(current.last, r.last)
                current = LongRange(current.first, endInclusive)
            } else {
                result.add(current)
                current = r
            }
        }
        result.add(current)
        return result
    }
}