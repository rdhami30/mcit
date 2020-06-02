package module2project.model

import scala.io.Source

case class Calendar (service_id: String,monday: String,tuesday: String,wednesday: String,thursday: String,friday: String,saturday: String,sunday: String,start_date: String,end_date: String)//service_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday,start_date,end_date
object Calendar {
  def apply(): List[Calendar] = {
    val fileSource = Source.fromFile("src/main/scala/module2project/iofiles/input/calendar.txt")
    val calendar: List[Calendar] = fileSource
      .getLines.drop(1)
      .toList
      .map(_.split(",", -1))
      .map(cols => Calendar(cols(0), cols(1), cols(2), cols(3), cols(4), cols(5), cols(6), cols(7), cols(8), cols(9)))
    fileSource.close
    calendar
  }
}
