package archive.day04

import scala.annotation.tailrec
import scala.io._

class Day04 {

  private val dataPath = "src/main/scala/archive/day04/resources/data.txt"

  def readBingo(path: String): Bingo = {
    val source = Source.fromFile(path)
    val iterator = source.getLines()

    val numbersRow = iterator.next()
    val numbers = numbersRow.split(",").map(_.toInt).toList

    val cardStrings =
      iterator.filter(_ != "").toList.flatMap {
        cardString =>
          cardString.split(",").map(_.trim)
      }

    val cardInts =
      cardStrings.flatMap(_
        .replace("  ", " ")
        .split(" ")
        .map(_.toInt)
      ).grouped(5).toList

    val allBingoItems: List[BingoItem] = cardInts.zipWithIndex.flatMap(row => createBingoBoard(row._1, y = row._2 +1))

    val cards: List[Card] = allBingoItems.grouped(25).map(Card).toList

    Bingo(numbers, cards)
  }

  @tailrec
  private def createBingoBoard(
    values: List[Int],
    x: Int = 0,
    y: Int,
    count: Int = 0,
    bingoItems: List[BingoItem] = List()
  ): List[BingoItem] = {
    values match {
      case Nil => bingoItems
      case h :: tail =>
        val newX = if(count % 5 == 0 ) 1 else x + 1

        createBingoBoard(tail, newX, y, count + 1, bingoItems :+ BingoItem(h, newX, y))
    }
  }
}

case class Card(items: List[BingoItem]){
  def isWinner: Boolean = {
    val rows: Map[Int, List[BingoItem]] = items.groupBy(_.x)
    val cols: Map[Int, List[BingoItem]] = items.groupBy(_.y)

    val winnerRow: Boolean = rows.map {
      case (_, v) => v.count(_.called == true)
    }.toList.contains(5)

    val winnerCol: Boolean = cols.map {
      case (_, v) => v.count(_.called == true)
    }.toList.contains(5)

    winnerRow || winnerCol
  }
}
case class Bingo(numbers: List[Int], items: List[Card])
case class BingoItem(value: Int, x: Int, y: Int, called: Boolean = false)