package gov.raleighnc.switchyard.integration.service.classdb.course;

import gov.raleighnc.switchyard.integration.domain.cityworks.workorder.WorkOrder;

/**
 * Switchyard REST-based "Composite Reference" to interact with Cityworks integration services.
 * 
 * @author mikev
 *
 */
public interface CourseCwRestInterface {
	/**
	 * Create a work order in Cityworks by passing in a JSON string representing the work order that
	 * the integration service requires and get the Cityworks work order id that was used for the
	 * corresponding work order.
	 * 
	 * @param wo The work order to be created from course data
	 * @return The Cityworks work order id
	 */
	String createWorkOrder(WorkOrder wo);
}
