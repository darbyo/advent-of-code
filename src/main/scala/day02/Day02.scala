package day02

import scala.collection.immutable.Nil
import scala.io._

class Day02 {

  private val dataPath = "src/main/scala/day02/resources/data.txt"
  private val defaultDivePosition = DivePosition(0, 0)

  def day02task01() = {
    val divePosition = dive1(readDiveInstructions(dataPath))

    divePosition.horizontalPosition * divePosition.depth
  }

  def day02task02() = {
    val divePosition = dive2(readDiveInstructions(dataPath))

    divePosition.horizontalPosition * divePosition.depth
  }

  def dive1(l: List[DiveInstruction], position: DivePosition = defaultDivePosition): DivePosition = {
    l match {
      case Nil => position
      case head :: tail =>
        val newPosition = head.direction match {
          case "forward" => position.copy(horizontalPosition = position.horizontalPosition + head.distance)
          case "up" => position.copy(depth = position.depth - head.distance)
          case "down" => position.copy(depth = position.depth + head.distance)
        }
        dive1(tail,newPosition)
    }
  }

  def dive2(l: List[DiveInstruction], aim: Int = 0, position: DivePosition = defaultDivePosition): DivePosition = {
    l match {
      case Nil => position
      case head :: tail =>
        val (newAim, newPosition) = head.direction match {
          case "forward" => (
            aim,
            position.copy(
              horizontalPosition = position.horizontalPosition + head.distance,
              depth = position.depth + aim * head.distance
            )
          )
          case "up" => (aim - head.distance, position)
          case "down" => (aim + head.distance, position)
        }

        dive2(tail, newAim, newPosition)
    }
  }

  def readDiveInstructions(path: String): List[DiveInstruction] = {
    val source = Source.fromFile(path)

    source.getLines
      .map{
        line =>
          val fullInstruction = line.split(" ")

          DiveInstruction(
            fullInstruction.head,
            fullInstruction(1).toInt
          )
      }.toList
  }
}

case class DiveInstruction(direction: String, distance: Int)
case class DivePosition(horizontalPosition: Int, depth: Int)