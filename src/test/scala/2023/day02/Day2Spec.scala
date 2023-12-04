package `2023`

import org.scalatest.{FreeSpec, MustMatchers}

class Day2Spec extends FreeSpec with MustMatchers {

    val day2 = new Day2

    "readStringsFromFile" - {

        "should return one String from a file" in {
            day2.readStringsFromFile(
                "src/test/scala/2023/day02/resources/value.txt"
            ) mustBe Seq("100")
        }

        "should return multiple Strings from a file" in {
            day2.readStringsFromFile(
                "src/test/scala/2023/day02/resources/values.txt"
            ) mustBe Seq("100", "101", "102", "103")
        }
    }

    "Day2.part1" - {

        "should return correctly for 1 valid game" in {
            val dataPath = "src/test/scala/2023/day02/resources/oneRow.txt"

            day2.part1(dataPath) mustBe 1
        }

        "should return correctly for 1 invalid game" in {
            val dataPath = "src/test/scala/2023/day02/resources/oneRowInvalid.txt"
            
            day2.part1(dataPath) mustBe 0
        }

        "should return correctly for multiple valid games" in {
            val dataPath = "src/test/scala/2023/day02/resources/multipleRows.txt"
        
            day2.part1(dataPath) mustBe 8
        }

        "should return day2 part1" in {
            val dataPath = "src/main/scala/2023/day02/data.txt"
            
            day2.part1(dataPath) mustBe 2541
        }
    }

    "Day2.part2" - {

        "should return correctly for 1 valid game" in {
            val dataPath = "src/test/scala/2023/day02/resources/oneRow.txt"
            day2.part2(dataPath) mustBe 48
        }

        "should return correctly for multiple valid games" in {
            val dataPath = "src/test/scala/2023/day02/resources/multipleRows.txt"
            day2.part2(dataPath) mustBe 2286
        }

        "should return day2 part2" in {
            val dataPath = "src/main/scala/2023/day02/data.txt"
            
            day2.part2(dataPath) mustBe 66016
        }
    }
}
