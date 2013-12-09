package gov.raleighnc.switchyard.integration.service.classdb.course.converter;

import gov.raleighnc.switchyard.integration.domain.classdb.course.Course;
import gov.raleighnc.switchyard.integration.service.classdb.course.iterator.CourseIterator;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Converter;

/**
 * Custom type converter used to convert from {@link Course} into {@link Iterator}
 * as well as the creation of Courses from the Class database record query.
 * 
 * @author mikev
 */
@Converter
public class CourseConverter {
	 /**
     * Wraps Rental into iterator.
     * 
     * @param rental Rental.
     * @return
     */
    @Converter
    public static Iterator<Object> from(Course course) {
        return new CourseIterator(course);
    }
    
    @Converter
    public static Course[] from(List<Map<String, Object>> objects) {
    	Course[] courses = new Course[objects.size()];
        int position = 0;
        for (Map<String, Object> course : objects) {

        	courses[position++] = new Course(
                (Integer)course.get("Maintenance Booking"),
                (Date)course.get("Maintenance Start"),
                (Date)course.get("Maintenance End"),
                (Integer)course.get("Related Booking"),
                (String)course.get("Related Booking Type"),
                (Integer)course.get("Related Booking Reference"),
                (String)course.get("Course Barcode"),
                (String)course.get("Activity Title"),
                (String)course.get("Course Title")
            );
        }
        return courses;
    }
}
