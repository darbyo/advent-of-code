import org.scalatest.{FreeSpec, MustMatchers}

class MainSpec extends FreeSpec with MustMatchers {

  val main = new Main

  "readIntsFromFile" - {

    "should return one Int from a file" in {
      main.readIntsFromFile("src/test/scala/resources/day1/value.txt") mustBe Seq(100)
    }

    "should return multiple Ints from a file" in {
      main.readIntsFromFile("src/test/scala/resources/day1/values.txt") mustBe Seq(100, 101, 102, 103)
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

    "should for multiple increases" in {
      main.countIncreases(List(1, 2, 3, 4, 5, 4, 3, 2, 1)) mustBe 4
    }
  }

  "run day01task01" in {
    main.day01task01() mustBe 1581
  }
}