package gov.raleighnc.switchyard.integration.service.classdb.course.iterator;

import gov.raleighnc.switchyard.integration.domain.classdb.course.Course;

import java.util.Iterator;

/**
 * 
 * Iterator implementation for {@link Course}.
 * 
 * @author mikev
 */
public class CourseIterator implements Iterator<Object> {
    private final Course course;
    private int pointer;

    public CourseIterator(Course course) {
        this.course = course;
    }

    @Override
    public boolean hasNext() {
        return pointer < 9;
    }

    @Override
    public Object next() {
        switch (pointer++) {
	        case 0: return course.getMaintenanceBooking();
	        case 1: return course.getMaintenanceStart();
	        case 2: return course.getMaintenanceEnd();
	        case 3: return course.getRelatedBooking();
	        case 4: return course.getRelatedBookingType();
	        case 5: return course.getRelatedBookingReference();
	        case 6: return course.getBarcodeNumber();
	        case 7: return course.getActivityTitle();
	        case 8: return course.getCourseTitle();
        }
        
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}