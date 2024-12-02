package `2024`.day01

import utils.FileReader
import utils.FileReader.readStringsFromFile

class Day1 {

  def part1(dataPath: String): Int = {
    run(
      dataPath,
      (li1, li2, _) => if (li1 >= li2) li1 - li2 else li2 - li1
    )
  }

  def part2(dataPath: String): Int = {
    run(
      dataPath,
      (li1, _, orderedList2) => li1 * orderedList2.count(_ == li1)
    )
  }

  private def run(dataPath: String, f: (Int, Int, List[Int]) => Int): Int = {
    val orderedList1 = readStringsFromFile(dataPath).map(item => item.split(" +")(0).toInt).sortWith(_ < _)
    val orderedList2 = readStringsFromFile(dataPath).map(item => item.split(" +")(1).toInt).sortWith(_ < _)

    (for (i <- orderedList1.indices) yield {
      val li1 = orderedList1(i)
      val li2 = orderedList2(i)

      f(li1, li2, orderedList2)
    }).sum
  }
}