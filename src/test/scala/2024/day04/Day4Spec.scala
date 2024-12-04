package `2024`.day04

import org.scalatest.{FreeSpec, MustMatchers}

class Day4Spec extends FreeSpec with MustMatchers {

  val day4 = new Day4

  "Day4.part1" - {

    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day04/resources/values.txt"
      day4.part1(dataPath) mustBe 18
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day04/resources/fullValues.txt"
      day4.part1(dataPath) mustBe 2358
    }
  }

  "Day4.part2" - {
    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day04/resources/values.txt"
      day4.part2(dataPath) mustBe 9
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day04/resources/fullValues.txt"
      day4.part2(dataPath) mustBe 1737
    }
  }
}