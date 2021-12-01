import scala.collection.immutable.Nil
import scala.io._

class Main {

  def day01task01() = {
    countIncreases(readIntsFromFile("src/main/resources/day-1-data.txt"))
  }

  def readIntsFromFile(path: String): List[Int] = {
    val source = Source.fromFile(path)

    source.getLines
      .map(_.trim.toInt)
      .toList
  }

  def countIncreases(l: List[Int], count: Int = 0): Int = {
    l match {
      case head :: tail if tail != Nil =>
        if (head < tail.head) countIncreases(tail, count + 1) else countIncreases(tail, count)
      case _ => count
    }
  }
}