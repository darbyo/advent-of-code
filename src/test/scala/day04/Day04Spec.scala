package day04

import org.scalatest.{FreeSpec, MustMatchers}

class Day04Spec extends FreeSpec with MustMatchers {

  val main = new Day04

  private def bi(value: Int, x: Int, y: Int) = {
    BingoItem(value, x ,y)
  }

  "readDiveInstructions" - {

    "should return 1 DiveInstruction from a file" in {
      val bingo = main.readBingo("src/test/scala/day04/resources/values.txt")

      bingo.numbers mustBe List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
      bingo.items.size mustBe 1
      bingo.items mustBe
        List(
          Card(
            List(
              bi(22, 1, 1), bi(13, 2, 1), bi(17, 3, 1), bi(11, 4, 1), bi(0, 5, 1),
              bi(8, 1, 2), bi(2, 2, 2), bi(23, 3, 2), bi(4, 4, 2), bi(24, 5, 2),
              bi(21, 1, 3), bi(9, 2, 3), bi(14, 3, 3), bi(16, 4, 3), bi(7, 5, 3),
              bi(6, 1, 4), bi(10, 2, 4), bi(3, 3, 4), bi(18, 4, 4), bi(5, 5, 4),
              bi(1, 1, 5), bi(12, 2, 5), bi(20, 3, 5), bi(15, 4, 5), bi(19, 5, 5)
            )
          )
        )
    }
  }

  "dive1" - {

//    val defaultDivePosition = DivePosition(0, 0)
//
//    "should return 0, 0 for no DiveInstructions" in {
//      main.dive1(List.empty) mustBe defaultDivePosition
//    }

  }

//  "run day02task01" in {
//    main.day02task01() mustBe 1250395
//  }
//
//  "run day02task02" in {
//    main.day02task02() mustBe 1451210346
//  }
}