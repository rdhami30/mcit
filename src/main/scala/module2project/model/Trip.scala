package module2project.model

import scala.io.Source

case class Trip (route_id: String,service_id: String,trip_id: String,trip_headsign: String,direction_id: String,shape_id: String,wheelchair_accessible: String,note_fr: String,note_en: String)//route_id,service_id,trip_id,trip_headsign,direction_id,shape_id,wheelchair_accessible,note_fr,note_en
object Trip {
  def apply(): List[Trip] = {
    val fileSource = Source.fromFile("src/main/scala/module2project/iofiles/input/trips.txt")
    val trips: List[Trip] = fileSource
      .getLines.drop(1)
      .toList
      .map(_.split(",", -1))
      .map(cols => Trip(cols(0), cols(1), cols(2), cols(3), cols(4), cols(5), cols(6), cols(7), cols(8)))
    fileSource.close
    trips
  }
}