package module2project

import module2project.model.Calendar

class CalendarLookup(calendars: List[Calendar]) {
  private val lookupTable: Map[String, Calendar] =
    calendars.map(calendar => calendar.service_id -> calendar).toMap
  def lookup(serviceId: String): Calendar = lookupTable.getOrElse(serviceId, null)
}
