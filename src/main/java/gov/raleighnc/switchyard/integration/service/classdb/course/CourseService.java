package gov.raleighnc.switchyard.integration.service.classdb.course;

import gov.raleighnc.switchyard.integration.domain.classdb.course.Course;

/**
 * A Switchyard "Composite Service" consisting of course services (from the Class database) usable by the outside world.
 * 
 * @author mikev
 *
 */
public interface CourseService {
	/**
	 * Create a Cityworks work order for each course passed.
	 * 
	 * @param courses An array of course information to create work orders from
	 */
	void createWorkOrder(Course[] courses);
}