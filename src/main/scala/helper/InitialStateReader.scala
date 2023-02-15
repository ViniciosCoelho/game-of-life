package helper

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object InitialStateReader:
	def readFile(filePath: String): ArrayBuffer[ArrayBuffer[Boolean]] =
		val initialState = ArrayBuffer[ArrayBuffer[Boolean]]()
		val file = Source.fromFile(filePath)
		for line <- file.getLines() do
			val values = line.split(",").map(_.trim()).map(_ match
				case "0" => false
				case "1" => true)
			initialState += ArrayBuffer(values: _ *)
		file.close()
		initialState