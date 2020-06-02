package module2project

import java.io.{File, PrintWriter}

import module2project.model.{EnrichedTrip, Route}

object Main extends App {
  val writer = new PrintWriter(new File("src/main/scala/module2project/iofiles/output//enrichedTrip.csv"))
  writer.write("Trip Id, Route Id, Service Id, Trip Head Sign, Route Name, Monday\n")

  EnrichedTrip().foreach(enrichedTrip => writer.write(
    enrichedTrip.tripRoute.trips.trip_id +
      "," + (if (enrichedTrip.tripRoute.routes != null) enrichedTrip.tripRoute.routes.route_id else "NA") +
      "," + (enrichedTrip.tripRoute.trips.service_id) +
      "," + (enrichedTrip.tripRoute.trips.trip_headsign) +
      "," + (if (enrichedTrip.tripRoute.routes != null) enrichedTrip.tripRoute.routes.route_long_name else "NA") +
      "," + (if (enrichedTrip.calendar != null) { if (enrichedTrip.calendar.monday.equals("1")) "Yes" else "No"} else "NA") +
      "\n"))
  writer.close()
}