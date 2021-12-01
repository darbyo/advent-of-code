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
    val threeHead = l.splitAt(3)._1

    l match {
      case _ :: tail if tail.size >= 3 =>
        if (tail.take(3).sum > threeHead.sum) {
          countIncreasesInThrees(tail, count + 1)
        } else {
          countIncreasesInThrees(tail, count)
        }
      case _ => count
    }
  }

  def countIncreases(l: List[Int], count: Int = 0): Int = {
    l match {
      case head :: tail if tail != Nil =>
        if (head < tail.head) countIncreases(tail, count + 1) else countIncreases(tail, count)
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