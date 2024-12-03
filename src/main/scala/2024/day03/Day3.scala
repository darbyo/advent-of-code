package `2024`.day03

import scala.util.matching.Regex
import utils.FileReader.readStringsFromFile

import scala.annotation.tailrec

class Day3 {

  def part1(dataPath: String): Int = {
    readStringsFromFile(dataPath).flatMap(row => {
      val regex = new Regex("mul\\((\\d+),(\\d+)\\)")
      val instructions = regex.findAllIn(row)

      instructions.toList.map(instruction => {
        val num1 = instruction.split(',')(0).replaceAll("[^0-9]", "").toInt
        val num2 = instruction.split(',')(1).replaceAll("[^0-9]", "").toInt

        num1 * num2
      })
    }).sum
  }

  def part2(dataPath: String): Int = {
    readStringsFromFile(dataPath).map(row => {
      val regex = new Regex("(mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\))")
      val instructions = regex.findAllIn(row).toList

      process(instructions, doDontFlag = true, 0)
    }).sum
  }

  @tailrec
  private def process(instructions: List[String], doDontFlag: Boolean, total: Int): Int = {
    instructions match {
      case Nil => total
      case instruction :: tail if instruction.startsWith("mul") =>
        val newTotal = if(doDontFlag) {
          val num1 = instruction.split(',')(0).replaceAll("[^0-9]", "").toInt
          val num2 = instruction.split(',')(1).replaceAll("[^0-9]", "").toInt

          (num1 * num2) + total
        } else total

        process(tail, doDontFlag, newTotal)
      case instruction :: tail => process(tail, instruction.startsWith("do()"), total)
    }
  }
}