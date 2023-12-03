package `2023`

import scala.io._

class Day1 {

  private val snums = List(
    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    "1", "2", "3", "4", "5", "6", "7", "8", "9"
  )

  private val numsMap = Map(
    "one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5,
    "six" -> 6, "seven" -> 7, "eight" -> 8, "nine" -> 9
  )

  def part1(dataPath: String) = {
    readStringsFromFile(dataPath).map(row => {
      val letterlessRow = row.toLowerCase.replaceAll("[a-z]", "")
      
      s"${letterlessRow.charAt(0)}${letterlessRow.charAt(letterlessRow.length()-1)}".toInt
    }).sum
  }

  def part2(dataPath: String) = {

    readStringsFromFile(dataPath).map(row => {
      val numPositions: List[(String, Int)] = (for {
        num <- snums
      } yield {
        List((num, row.indexOf(num)), (num, row.lastIndexOf(num)))
      }).filterNot(position => position(0)._2 == -1 || position(1)._2 == -1).flatten

      val minPosition = numPositions.map(x => x._2).min
      val maxPosition = numPositions.map(x => x._2).max

      val firstNum = numPositions.filter(x => x._2 == minPosition)(0)._1
      val lastNum  = numPositions.filter(x => x._2 == maxPosition)(0)._1
      
      s"${convertNum(firstNum)}${convertNum(lastNum)}".toInt
    }).sum
  }

  private def convertNum(s: String) = {
    try {
      s.toInt
    } catch {
      case _ : Exception => numsMap(s)
    }
  }

  def readStringsFromFile(path: String): List[String] = {
    Source.fromFile(path)
      .getLines
      .map(_.trim)
      .toList
  }
}