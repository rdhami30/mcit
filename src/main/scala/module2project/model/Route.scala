package module2project.model

import scala.io.Source

case class Route (route_id: String,agency_id: String,route_short_name: String,route_long_name: String,route_type: String,route_url: String,route_color: String,route_text_color: String)//route_id,agency_id,route_short_name,route_long_name,route_type,route_url,route_color,route_text_color
object Route {
  def apply(): List[Route] = {
    val fileSource = Source.fromFile("src/main/scala/module2project/iofiles/input/routes.txt")
    val routes: List[Route] = fileSource
      .getLines.drop(1)
      .toList
      .map(_.split(",", -1))
      .map(cols => Route(cols(0), cols(1), cols(2), cols(3), cols(4), cols(5), cols(6), cols(7)))
    fileSource.close
    routes
  }
}