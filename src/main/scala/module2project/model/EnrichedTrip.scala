package module2project.model

import module2project.CalendarLookup

case class EnrichedTrip(tripRoute: TripRoute, calendar: Calendar)
object EnrichedTrip {
  def apply(): List[EnrichedTrip] = {
    val enrichedTripRoutes =
      TripRoute().map(tripRoute => {
        new EnrichedTrip(tripRoute, new CalendarLookup(Calendar()).lookup(tripRoute.trips.service_id))
      })
    enrichedTripRoutes
  }
}