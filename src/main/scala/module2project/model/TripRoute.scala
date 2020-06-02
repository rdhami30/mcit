package module2project.model

import module2project.RouteLookup

case class TripRoute(trips: Trip, routes: Route)
object TripRoute {
  def apply(): List[TripRoute] = {
    val enrichedTripRoutes =
      Trip().map(trip => {
        new TripRoute(trip, new RouteLookup(Route()).lookup(trip.route_id))
      })
    enrichedTripRoutes
  }
}