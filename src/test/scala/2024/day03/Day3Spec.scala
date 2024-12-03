package `2024`.day03

import org.scalatest.{FreeSpec, MustMatchers}

class Day3Spec extends FreeSpec with MustMatchers {

  val day3 = new Day3

  "Day3.part1" - {

    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day03/resources/values.txt"
      day3.part1(dataPath) mustBe 161
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day03/resources/fullValues.txt"
      day3.part1(dataPath) mustBe 159892596
    }
  }

  "Day3.part2" - {
    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day03/resources/valuesDoDont.txt"
      day3.part2(dataPath) mustBe 48
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day03/resources/fullValues.txt"
      day3.part2(dataPath) mustBe 92626942
    }
  }
}
