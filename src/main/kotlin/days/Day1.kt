package days

import java.lang.Math.floorMod

@AdventOfCodePuzzle(
    name = "Secret Entrance",
    url = "https://adventofcode.com/2025/day/1",
    date = Date(day = 1, year = 2025)
)
class Day1(private val input: List<String>) : Puzzle {

    private val positions = 100
    private val start = 50
    private val pairs = input.map { it[0] to it.substring(1).toInt() }

    override fun partOne(): Int {
        return pairs.scan(start) { acc, (turn, value) ->
            when (turn) {
                'L' -> floorMod(acc - value, positions)
                'R' -> floorMod(acc + value, positions)
                else -> acc
            }
        }.count { it == 0 }
    }

    override fun partTwo(): Int {
        return sequence {
            var start = start;
            yield(start);
            for ((turn, value) in pairs) {
                when (turn) {
                    'L' -> repeat(value) {
                        start = floorMod(start - 1, positions).also { yield(it) }
                    }

                    'R' -> repeat(value) {
                        start = floorMod(start + 1, positions).also { yield(it) }
                    }

                    else -> throw IllegalArgumentException("Unknown turn $turn")
                }
            }
        }.count { it == 0 }
    }

}