package day01

import org.scalatest.{FreeSpec, MustMatchers}

class Day01Spec extends FreeSpec with MustMatchers {

  val main = new Day01

  "readIntsFromFile" - {

    "should return one Int from a file" in {
      main.readIntsFromFile("src/test/scala/day01/resources/value.txt") mustBe Seq(100)
    }

    "should return multiple Ints from a file" in {
      main.readIntsFromFile("src/test/scala/day01/resources/values.txt") mustBe Seq(100, 101, 102, 103)
    }
  }

  "countIncrease" - {

    "should return zero" - {

      "for an empty list" in {
        main.countIncreases(List.empty) mustBe 0
      }

      "for a list with one item" in {
        main.countIncreases(List(1)) mustBe 0
      }

      "for a list with multiple items and no increases" in {
        main.countIncreases(List(3, 2, 1)) mustBe 0
      }
    }

    "should return one" - {

      "for a list with one increase" in {
        main.countIncreases(List(1, 2)) mustBe 1
      }

      "for a list with one increase and multiple items" in {
        main.countIncreases(List(1, 2, 2, 1)) mustBe 1
      }
    }

    "should return multiple increases" in {
      main.countIncreases(List(1, 2, 3, 4, 5, 4, 3, 2, 1)) mustBe 4
    }
  }

  "countIncreasesInThrees" - {

    "should return 0" - {

      "for empty list" in {
        main.countIncreasesInThrees(List.empty) mustBe 0
      }

      "when less than 2 comparable sets of elements" in {
        main.countIncreasesInThrees(List(1, 1, 1, 1, 1)) mustBe 0
      }

      "when 2 comparable sets of elements but no increase" in {
        main.countIncreasesInThrees(List(1, 1, 1, 1, 1, 1)) mustBe 0
      }
    }

    "should return 1" - {

      "when 2 comparable sets of elements and 1 increase" in {
        main.countIncreasesInThrees(List(1, 1, 1, 1, 1, 2)) mustBe 1
      }

      "when multiple comparable sets of elements and 1 increase" in {
        main.countIncreasesInThrees(List(1, 1, 1, 2, 1, 1, 1)) mustBe 1
      }
    }

    "should return multiple when multiple comparable sets of elements and multiple increases" in {
      main.countIncreasesInThrees(List(1, 1, 1, 1, 1, 2, 3, 4)) mustBe 3
    }
  }

  "run day01task01" in {
    main.day01task01() mustBe 1581
  }

  "run day01task02" in {
    main.day01task02() mustBe 1618
  }
}