object SalaryCalculator {

   
  val normalHourlyRate: Double = 250.0
  val otHourlyRate: Double = 85.0
  val taxRate: Double = 0.12

   
  def calculateGrossSalary(normalHours: Int, otHours: Int): Double = {
    (normalHours * normalHourlyRate) + (otHours * otHourlyRate)
  }

   
  def calculateTakeHomeSalary(normalHours: Int, otHours: Int): Double = {
    val grossSalary = calculateGrossSalary(normalHours, otHours)
    val taxAmount = grossSalary * taxRate
    grossSalary - taxAmount
  }

   
  def main(args: Array[String]): Unit = {
    val normalHours = 40
    val otHours = 30
    val takeHomeSalary = calculateTakeHomeSalary(normalHours, otHours)
    println(f"Take-home salary for $normalHours normal hours and $otHours OT hours is: Rs. $takeHomeSalary%.2f")
  }
}
