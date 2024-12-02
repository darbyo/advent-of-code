package `2024`.day01

import org.scalatest.{FreeSpec, MustMatchers}

class Day1Spec extends FreeSpec with MustMatchers {

    val day1 = new Day1

    "Day1.part1" - {

        "should return correctly for test file" in {
            val dataPath = "src/test/scala/2024/day01/resources/values.txt"
            day1.part1(dataPath) mustBe 11
        }

        "should return correctly for full file" in {
            val dataPath = "src/test/scala/2024/day01/resources/fullValues.txt"
            day1.part1(dataPath) mustBe 1388114
        }
    }

    "Day1.part2" - {
        "should return correctly for test file" in {
            val dataPath = "src/test/scala/2024/day01/resources/values.txt"
            day1.part2(dataPath) mustBe 31
        }

        "should return correctly for full file" in {
            val dataPath = "src/test/scala/2024/day01/resources/fullValues.txt"
            day1.part2(dataPath) mustBe 23529853
        }
    }
}
