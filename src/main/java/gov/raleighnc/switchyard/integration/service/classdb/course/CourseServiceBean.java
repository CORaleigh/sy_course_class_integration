package gov.raleighnc.switchyard.integration.service.classdb.course;


import gov.raleighnc.switchyard.integration.domain.cityworks.workorder.WorkOrder;
import gov.raleighnc.switchyard.integration.domain.classdb.booking.BookingWorkOrder;
import gov.raleighnc.switchyard.integration.domain.classdb.course.Course;

import javax.inject.Inject;

import org.switchyard.component.bean.Property;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;


/**
 * Switchyard "Component" that is a "Bean Implementation" and implements the CourseService contract.
 * 
 * @author mikev
 *
 */
@Service(CourseService.class)
public class CourseServiceBean implements CourseService {
	@Inject
	@Reference
	private CourseCwRestInterface cwRestInterface;
	
	@Inject
	@Reference
	private CourseCwJpaInterface cwJpaInterface;
	
	@Inject
	@Reference
	private CourseCwSqlInterface cwSqlInterface;
	
	@Property(name = "supervisor")
	private String supervisor;
	
	@Property(name = "requestedBy")
	private String requestedBy;
	
	@Property(name = "initiatedBy")
	private String initiatedBy;
	
	@Property(name = "priority")
	private String priority;
	
	@Property(name = "numDaysBefore")
	private String numDaysBefore;
	
	@Property(name = "woCategory")
	private String woCategory;
	
	@Property(name = "submitTo")
	private String submitTo;
	
	@Property(name = "status")
	private String status;
	
	@Property(name = "woTemplateId")
	private String woTemplateId;
	
	@Override
	public void createWorkOrder(Course[] courses) {
		for (Course course : courses) {
			// first check to see if a WO has already been created for this course
			BookingWorkOrder[] results = cwSqlInterface.getBookingWoMapping(course.getMaintenanceBooking());
			
			if (results != null && results.length > 0) {
				// since we found at least one BookingWorkOrder record (should only be one record) from the 
				// mapping table, that means we already created a WO for this booking hence skip this particular
				// record from being created as a new WO
				continue;
			}
			
			// create the WO from course information
			WorkOrder wo = new WorkOrder();
			wo.setWorkOrderId(course.getMaintenanceBooking().toString());
			wo.setLocation(course.getBarcodeNumber());
			wo.setDescription(course.getCourseTitle());
			wo.setProjectStartDate(course.getMaintenanceStart());
			wo.setProjectFinishDate(course.getMaintenanceEnd());
			wo.setInitiateDate(course.getMaintenanceStart());
			wo.setSupervisor(supervisor);
			wo.setRequestedBy(requestedBy);
			wo.setInitiatedBy(initiatedBy);
			wo.setPriority(priority);
			wo.setNumDaysBefore(Integer.parseInt(numDaysBefore));
			wo.setWoCategory(woCategory);
			wo.setSubmitTo(submitTo);
			wo.setStatus(status);
			wo.setWoTemplateId(woTemplateId);
			
			String cwWoId = cwRestInterface.createWorkOrder(wo);
			
			// store the mapping between WO id and booking id
			if (cwWoId != null && cwWoId.length() > 0) {
				BookingWorkOrder bwo = new BookingWorkOrder(course.getMaintenanceBooking(), cwWoId);
				cwJpaInterface.createBookingWoMapping(bwo);
			}
		}
	}
}