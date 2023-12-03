package `2023`

import org.scalatest.{FreeSpec, MustMatchers}

class Day1Spec extends FreeSpec with MustMatchers {

    val day1 = new Day1

    "readStringsFromFile" - {

        "should return one String from a file" in {
            day1.readStringsFromFile(
                "src/test/scala/2023/day01/resources/value.txt"
            ) mustBe Seq("100")
        }

        "should return multiple Strings from a file" in {
            day1.readStringsFromFile(
                "src/test/scala/2023/day01/resources/values.txt"
            ) mustBe Seq("100", "101", "102", "103")
        }
    }

    "Day1.part1" - {

        "should return correctly for one row" in {
            val dataPath = "src/test/scala/2023/day01/resources/oneRow.txt"
            day1.part1(dataPath) mustBe 84
        }

        "should return correctly for multiple rows" in {
            val dataPath = "src/test/scala/2023/day01/resources/multipleRows.txt"
            day1.part1(dataPath) mustBe 249
        }

        "should return day1 part1" in {
            val dataPath = "src/main/scala/2023/day01/data.txt"
            day1.part1(dataPath) mustBe 54877
        }
    }

    "Day1.part2" - {

        "should return correctly for one row with numbers" in {
            val dataPath = "src/test/scala/2023/day01/resources/oneRow.txt"
            day1.part2(dataPath) mustBe 34
        }

        "should return correctly for one row with duplicate numbers" in {
            val dataPath = "src/test/scala/2023/day01/resources/oneRowDupes.txt"
            day1.part2(dataPath) mustBe 44
        }

        "should return correctly for multiple rows" in {
            val dataPath = "src/test/scala/2023/day01/resources/multipleRows.txt"
            day1.part2(dataPath) mustBe 44 + 33 + 88 + 39
        }

        "should return day1 part2" in {
            val dataPath = "src/main/scala/2023/day01/data.txt"
            day1.part2(dataPath) mustBe 54100
        }
    }
}
