package gov.raleighnc.switchyard.integration.service.classdb.course;

import gov.raleighnc.switchyard.integration.domain.classdb.booking.BookingWorkOrder;

/**
 * Switchyard JPA-based "Composite Reference" accessing the Cityworks system.
 * 
 * @author mikev
 *
 */
public interface CourseCwJpaInterface {
	/**
	 * Create a work order / booking mapping in the Cityworks DB given the 
	 * BookingWorkOrder domain object populated with the appropriate values.
	 * 
	 * @param bwo The BookingWorkOrder domain object
	 */
	void createBookingWoMapping(BookingWorkOrder bwo);
}