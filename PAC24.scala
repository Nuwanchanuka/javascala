object MovieTheaterProfit {

  def attendance(ticketPrice: Double): Int = {
    val basePrice = 15.0
    val baseAttendance = 120
    val priceChange = 5.0
    val attendanceChange = 20

    val priceDifference = ticketPrice - basePrice
    val attendanceChangeCount = (priceDifference / priceChange).toInt

    baseAttendance - (attendanceChangeCount * attendanceChange)
  }

  def totalCost(attendance: Int): Double = {
    val fixedCost = 500.0
    val variableCostPerAttendee = 3.0

    fixedCost + (variableCostPerAttendee * attendance)
  }

  def profit(ticketPrice: Double): Double = {
    val currentAttendance = attendance(ticketPrice)
    val revenue = ticketPrice * currentAttendance
    val cost = totalCost(currentAttendance)

    revenue - cost
  }


  def bestTicketPrice(minPrice: Double, maxPrice: Double, priceStep: Double): Double = {
    val prices = BigDecimal(minPrice) to BigDecimal(maxPrice) by BigDecimal(priceStep)
    val profits = prices.map(price => (price.toDouble, profit(price.toDouble)))

    profits.maxBy(_._2)._1
  }

  def main(args: Array[String]): Unit = {
    val minPrice = 5.0
    val maxPrice = 50.0
    val priceStep = 0.5

    val optimalPrice = bestTicketPrice(minPrice, maxPrice, priceStep)
    val optimalProfit = profit(optimalPrice)

    println(f"The optimal ticket price is Rs.$optimalPrice%.2f with a profit of Rs.$optimalProfit%.2f")
  }
}