package `2024`.day02

import org.scalatest.{FreeSpec, MustMatchers}

class Day2Spec extends FreeSpec with MustMatchers {

  val day2 = new Day2

  "Day2.part1" - {

    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day02/resources/values.txt"
      day2.part1(dataPath) mustBe 2
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day02/resources/fullValues.txt"
      day2.part1(dataPath) mustBe 463
    }
  }

  "Day2.part2" - {
    "should return correctly for test file" in {
      val dataPath = "src/test/scala/2024/day02/resources/values.txt"
      day2.part2(dataPath) mustBe 4
    }

    "should return correctly for full file" in {
      val dataPath = "src/test/scala/2024/day02/resources/fullValues.txt"
      day2.part2(dataPath) mustBe 514
    }
  }
}
