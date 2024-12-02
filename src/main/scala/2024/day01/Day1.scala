package `2024`.day01

import scala.io._

class Day1 {

  def part1(dataPath: String): Int = {

    val orderedList1 = readStringsFromFile(dataPath).map(item => item.split(" +")(0).toInt).sortWith(_ < _)
    val orderedList2 = readStringsFromFile(dataPath).map(item => item.split(" +")(1).toInt).sortWith(_ < _)

    (for {
      i <- orderedList1.indices
    } yield {
      val li1 = orderedList1(i)
      val li2 = orderedList2(i)

      if(li1 >= li2) li1 -li2 else li2 - li1
    }).sum
  }

  def part2(dataPath: String): Int = {

    val orderedList1 = readStringsFromFile(dataPath).map(item => item.split(" +")(0).toInt).sortWith(_ < _)
    val orderedList2 = readStringsFromFile(dataPath).map(item => item.split(" +")(1).toInt).sortWith(_ < _)

    (for {
      i <- orderedList1.indices
    } yield {
      val li1 = orderedList1(i)
      val similarityMultiple = orderedList2.count(_ == li1)

      li1 * similarityMultiple
    }).sum
  }

  def readStringsFromFile(path: String): List[String] = {
    val source = Source.fromFile(path)
    val rows   = source.getLines.map(_.trim).toList

    source.close()
    rows
  }
}