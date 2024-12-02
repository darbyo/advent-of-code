package utils

import scala.io.Source

object FileReader {
  def readStringsFromFile(path: String): List[String] = {
    val source = Source.fromFile(path)
    val rows   = source.getLines.map(_.trim).toList

    source.close()
    rows
  }
}
