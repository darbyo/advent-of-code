package archive.day02

import org.scalatest.{FreeSpec, MustMatchers}

class Day02Spec extends FreeSpec with MustMatchers {

  val main = new Day02

  private val forwardInstruction = DiveInstruction("forward", 10)

  "readDiveInstructions" - {

    "should return 1 DiveInstruction from a file" in {
      main.readDiveInstructions("src/test/scala/archive/day02/resources/value.txt")
        .mustBe(List(forwardInstruction))
    }

    "should return multiple DiveInstruction from a file" in {
      main.readDiveInstructions("src/test/scala/archive/day02/resources/values.txt")
        .mustBe(List(forwardInstruction, forwardInstruction))
    }

    "should return all DiveInstruction types from a file" in {
      main.readDiveInstructions("src/test/scala/archive/day02/resources/allValues.txt")
        .mustBe(List(
          forwardInstruction,
          DiveInstruction("down", 10),
          DiveInstruction("up", 5)
        ))
    }
  }

  "dive1" - {

    val defaultDivePosition = DivePosition(0, 0)

    "should return 0, 0 for no DiveInstructions" in {
      main.dive1(List.empty) mustBe defaultDivePosition
    }

    "should return correct DivePosition for 1 DiveInstruction" in {
      main.dive1(List(forwardInstruction)) mustBe DivePosition(10, 0)
    }

    "should return correct DivePosition for multiple DiveInstructions" in {
      main.dive1(List(
        DiveInstruction("forward", 5),
        DiveInstruction("down", 5),
        DiveInstruction("forward", 8),
        DiveInstruction("up", 3),
        DiveInstruction("down", 8),
        DiveInstruction("forward", 2)
      )).mustBe(DivePosition(15, 10))
    }
  }

  "dive2" - {

    val defaultDivePosition = DivePosition(0, 0)

    "should return 0, 0 for no DiveInstructions" in {
      main.dive2(List.empty) mustBe defaultDivePosition
    }

    "should return correct DivePosition for 1 DiveInstruction" in {
      main.dive2(List(forwardInstruction)) mustBe DivePosition(10, 0)
    }

    "should return correct DivePosition for multiple DiveInstructions" in {
      main.dive2(List(
        DiveInstruction("forward", 5),
        DiveInstruction("down", 5),
        DiveInstruction("forward", 8),
        DiveInstruction("up", 3),
        DiveInstruction("down", 8),
        DiveInstruction("forward", 2)
      )).mustBe(DivePosition(15, 60))
    }
  }

  "run day02task01" in {
    main.day02task01() mustBe 1250395
  }

  "run day02task02" in {
    main.day02task02() mustBe 1451210346
  }
}