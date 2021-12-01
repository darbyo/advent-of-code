import scala.collection.immutable.Nil
import scala.io._

class Main {

  def day01task01() = {
    countIncreases(readIntsFromFile("src/main/scala/resources/day1/day-1-data.txt"))
  }

  def day01task02() = {
    countIncreasesInThrees(readIntsFromFile("src/main/scala/resources/day1/day-1-data.txt"))
  }

  def countIncreasesInThrees(l: List[Int], count: Int = 0): Int = {
    l match {
      case head :: tail if tail.size >= 3 =>
        countIncreasesInThrees(
          tail,
          if (tail.take(3).sum > (head :: tail.take(2)).sum) count + 1 else count
        )
      case _ => count
    }
  }

  def countIncreases(l: List[Int], count: Int = 0): Int = {
    l match {
      case head :: tail if tail != Nil =>
        countIncreases(
          tail,
          if (head < tail.head) count + 1 else count
        )
      case _ => count
    }
  }

  def readIntsFromFile(path: String): List[Int] = {
    val source = Source.fromFile(path)

    source.getLines
      .map(_.trim.toInt)
      .toList
  }
}