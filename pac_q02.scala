import scala.io.StdIn._

object StudentRecords {

  
  def getStudentInfo: (String, Int, Int, Double, Char) = {
    val (name, marks, totalMarks) = getStudentInfoWithRetry

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _            => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(s"Percentage: ${"%.2f".format(percentage)}%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else {
      try {
        val marksInt = marks.toInt
        val totalMarksInt = totalMarks.toInt
        if (marksInt < 0 || totalMarksInt < 0) {
          (false, Some("Marks and total marks must be positive integers"))
        } else if (marksInt > totalMarksInt) {
          (false, Some("Marks cannot exceed total marks"))
        } else {
          (true, None)
        }
      } catch {
        case _: NumberFormatException => (false, Some("Marks and total marks must be integers"))
      }
    }
  }

  def getStudentInfoWithRetry: (String, Int, Int) = {
    var valid = false
    var name = ""
    var marks = ""
    var totalMarks = ""
    var errorMessage: Option[String] = None

    while (!valid) {
      println("Enter student name:")
      name = readLine()
      println("Enter marks:")
      marks = readLine()
      println("Enter total possible marks:")
      totalMarks = readLine()

      val validationResult = validateInput(name, marks, totalMarks)
      valid = validationResult._1
      errorMessage = validationResult._2

      if (!valid) {
        println(s"Error: ${errorMessage.get}")
      }
    }

    (name, marks.toInt, totalMarks.toInt)
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfo
    printStudentRecord(studentInfo)
  }
}