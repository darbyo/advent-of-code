package `2023`

import scala.io._

class Day2 {

  def part1(dataPath: String) = {
    readStringsFromFile(dataPath).map(row => {
      val gameId   = row.split(":")(0).replace("Game ", "").toInt 
      val gameData = row.split(":")(1).replace(" ", "").replace(";", ",").split(",").toList
      
      val impossibleCount =
        (for(
          (colour, limit) <- Map("red" -> 12, "green" -> 13, "blue" -> 14)
        ) yield {
          gameData.filter(turn => turn.contains(colour))
                  .map(cube => cube.replace(colour, "").toInt)
                  .filter(colourCount => colourCount > limit)
                  .size
        }).sum

      impossibleCount match {
        case ic if(ic > 0) => 0
        case _             => gameId
      }
    }).sum
  }

  def part2(dataPath: String) = {
    readStringsFromFile(dataPath).map(row => {
      val gameId   = row.split(":")(0).replace("Game ", "").toInt 
      val gameData = row.split(":")(1).replace(" ", "").replace(";", ",").split(",").toList
      
      val highestRGB =
        (for(
          colour <- List("red", "green", "blue")
        ) yield {
          gameData.filter(turn => turn.contains(colour))
                  .map(cube => cube.replace(colour, "").toInt)
                  .max
        })
      
        highestRGB(0) * highestRGB(1) * highestRGB(2)

    }).sum
  }

  def readStringsFromFile(path: String): List[String] = {
    Source.fromFile(path)
      .getLines
      .map(_.trim)
      .toList
  }
}