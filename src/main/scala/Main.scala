import controller.GameOfLifeSimulation
import helper.InitialStateReader

import java.util.Collections
import scala.collection.mutable.ListBuffer
import scala.io.Source

@main def run(): Unit =
	println("Starting Conway's Game of Life.")
	val filePath = "test.csv"
	val seed = InitialStateReader.readFile(filePath)
	val simulation = GameOfLifeSimulation()
	simulation.start(seed)