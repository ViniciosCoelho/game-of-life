package controller

import view.Display

import scala.collection.mutable.ArrayBuffer

class GameOfLifeSimulation:
	def start(seed: ArrayBuffer[ArrayBuffer[Boolean]]): Unit =
		var state = seed
		while true do
			Display.show(state)
			state = iterate(state)
			Thread.sleep(1000)

	private def iterate(seed: ArrayBuffer[ArrayBuffer[Boolean]]): ArrayBuffer[ArrayBuffer[Boolean]] =
		val tick = ArrayBuffer[ArrayBuffer[Boolean]]()
		for i <- seed.indices do
			val tickLine = ArrayBuffer[Boolean]()
			tick.append(tickLine)
			for j <- seed(i).indices do
				tickLine.append(iterateCell(seed, i, j))
		tick

	private def iterateCell(seed: ArrayBuffer[ArrayBuffer[Boolean]], i: Int, j: Int): Boolean =
		val cell = seed(i)(j)
		if cell.eq(true) && hasTwoOrThreeLiveNeighbours(seed, i, j) then
			true
		else if cell.eq(false) && hasThreeLiveNeighbours(seed, i, j) then
			true
		else
			false

	private def hasTwoOrThreeLiveNeighbours(seed: ArrayBuffer[ArrayBuffer[Boolean]], i: Int, j: Int): Boolean =
		val neighboursCount = getAmountOfLiveNeighbours(seed, i, j)
		if neighboursCount == 2 || neighboursCount == 3 then true else false

	private def hasThreeLiveNeighbours(seed: ArrayBuffer[ArrayBuffer[Boolean]], i: Int, j: Int): Boolean =
		if getAmountOfLiveNeighbours(seed, i, j) == 3 then true else false

	private def getAmountOfLiveNeighbours(seed: ArrayBuffer[ArrayBuffer[Boolean]], i: Int, j: Int): Int =
		var count = 0
		for
			x <- i - 1 to i + 1
			if seed.indices.contains(x)
		do
			for
				y <- j - 1 to j + 1
				if seed(x).indices.contains(y)
				if x != i || y != j
			do
				if seed(x)(y).eq(true) then
					count += 1
		count