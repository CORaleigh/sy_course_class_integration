package gov.raleighnc.switchyard.integration.service.classdb.course;

import gov.raleighnc.switchyard.integration.domain.classdb.booking.BookingWorkOrder;

/**
 * Switchyard SQL-based "Composite Reference" for all course-based access to the Cityworks system.
 * 
 * @author mikev
 */
public interface CourseCwSqlInterface {
	BookingWorkOrder[] getBookingWoMapping(int bookingId); 
}