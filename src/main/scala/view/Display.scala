package view

import scala.collection.mutable.ArrayBuffer

object Display:
	def show(area: ArrayBuffer[ArrayBuffer[Boolean]]): Unit =
		println
		for line <- area do
			line.map(_ match
				case false => "_ "
				case true => "☒ ").foreach(print)
			println