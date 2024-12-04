package `2024`.day04

import utils.FileReader.readStringsFromFile

class Day4 {

  def part1(dataPath: String): Int = {
    implicit val letters: List[List[Char]] = readStringsFromFile(dataPath).map(_.toList)

    (for {
      y <- letters.indices
      x <- letters(y).indices
    } yield {
      //sorry not sorry
      List(
        s"${get(y, x)}${get(y, x + 1)}${get(y, x + 2)}${get(y, x + 3)}",
        s"${get(y, x)}${get(y, x - 1)}${get(y, x - 2)}${get(y, x - 3)}",
        s"${get(y, x)}${get(y + 1, x)}${get(y + 2, x)}${get(y + 3, x)}",
        s"${get(y, x)}${get(y - 1, x)}${get(y - 2, x)}${get(y - 3, x)}",
        s"${get(y, x)}${get(y - 1, x + 1)}${get(y - 2, x + 2)}${get(y - 3, x + 3)}",
        s"${get(y, x)}${get(y + 1, x + 1)}${get(y + 2, x + 2)}${get(y + 3, x + 3)}",
        s"${get(y, x)}${get(y - 1, x - 1)}${get(y - 2, x - 2)}${get(y - 3, x - 3)}",
        s"${get(y, x)}${get(y + 1, x - 1)}${get(y + 2, x - 2)}${get(y + 3, x - 3)}"
      ).count(_ == "XMAS")
    }).sum
  }

  def part2(dataPath: String): Int = {
    implicit val letters: List[List[Char]] = readStringsFromFile(dataPath).map(_.toList)

    (for {
      y <- letters.indices
      x <- letters(y).indices
    } yield {
      if (letters(y)(x) == 'A') {
        val maybeCrossMas = List(
          s"${get(x - 1, y + 1)}${get(x , y)}${get(x + 1, y - 1)}",
          s"${get(x - 1, y - 1)}${get(x , y)}${get(x + 1, y + 1)}"
        ).count( crossMas => crossMas == "MAS" || crossMas == "SAM")

        if(maybeCrossMas == 2) 1 else 0
      } else 0
    }).sum
  }

  private def get(x: Int, y: Int)(implicit letters: List[List[Char]]) = {
    try letters(y)(x)
    catch {case _ : IndexOutOfBoundsException => ' '}
  }
}