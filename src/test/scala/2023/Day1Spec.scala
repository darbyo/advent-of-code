package `2023`

import org.scalatest.{FreeSpec, MustMatchers}

class Day1Spec extends FreeSpec with MustMatchers {

    val day1 = new Day1

    "Day1.run" - {

        "should return day1" in {
            day1.run() mustBe "day1"
        }
  }
  
}
