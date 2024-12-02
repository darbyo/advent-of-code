package `2024`.day02

import utils.FileReader
import utils.FileReader.readStringsFromFile

import scala.annotation.tailrec

class Day2 {

  def part1(dataPath: String): Int = {
    readStringsFromFile(dataPath).map(row => {
      isSafe(row.split("\\s+").map(x => x.toInt).toList)
    }).count(_ == true)
  }

  def part2(dataPath: String): Int = {
    readStringsFromFile(dataPath).map(row => {
      isSafeWithRetry(
        row.split("\\s+").map(x => x.toInt).toList
      )
    }).count(_ == true)
  }

  private def isSafe(report: List[Int]): Boolean = {
    val allIncreasing = isIncreasingSafely(report)
    val allDecreasing = isDecreasingSafely(report)

    allIncreasing || allDecreasing
  }

  private def isSafeWithRetry(report: List[Int]): Boolean = {
    val allIncreasing = isIncreasingSafely(report)
    val allDecreasing = isDecreasingSafely(report)

    val allIncreasingRetry =
      (for (i <- report.indices) yield {
        val (before, after) = report.splitAt(i)
        val updatedReport = before ::: after.tail

        isIncreasingSafely(updatedReport)
      }).contains(true)

    val allDecreasingRetry =
      (for (i <- report.indices) yield {
        val (before, after) = report.splitAt(i)
        val updatedReport = before ::: after.tail

        isDecreasingSafely(updatedReport)
      }).contains(true)

    allIncreasing || allDecreasing || allIncreasingRetry || allDecreasingRetry
  }

  @tailrec
  private def isIncreasingSafely(report: List[Int]): Boolean = {
    report match {
      case Nil | _ :: Nil => true
      case x :: y :: tail =>
        val diff = y - x
        if (diff >= 1 && diff <= 3) isIncreasingSafely(y :: tail) else false
    }
  }

  @tailrec
  private def isDecreasingSafely(report: List[Int]): Boolean = {
    report match {
      case Nil | _ :: Nil => true
      case x :: y :: tail =>
        val diff = x - y
        if (diff >= 1 && diff <= 3) isDecreasingSafely(y :: tail) else false
    }
  }
}