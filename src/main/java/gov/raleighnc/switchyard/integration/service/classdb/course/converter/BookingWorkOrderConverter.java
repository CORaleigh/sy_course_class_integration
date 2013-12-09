package gov.raleighnc.switchyard.integration.service.classdb.course.converter;

import gov.raleighnc.switchyard.integration.domain.classdb.booking.BookingWorkOrder;
import gov.raleighnc.switchyard.integration.domain.classdb.booking.iterator.BookingWorkOrderIterator;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Converter;

/**
 * Custom type converter used to convert from {@link BookingWorkOrder} into {@link Iterator}
 * as well as the creation of BookingWorkOrders from the Class database record query.
 * 
 * @author mikev
 */
@Converter
public class BookingWorkOrderConverter {
	 /**
     * Wraps BookingWorkOrder into iterator.
     * 
     * @param bwo BookingWorkOrder.
     * @return
     */
    @Converter
    public static Iterator<Object> from(BookingWorkOrder bwo) {
        return new BookingWorkOrderIterator(bwo);
    }
    
    @Converter
    public static BookingWorkOrder[] from(List<Map<String, Object>> objects) {
    	BookingWorkOrder[] bwos = new BookingWorkOrder[objects.size()];
        int position = 0;
        for (Map<String, Object> bwo : objects) {
        	bwos[position++] = new BookingWorkOrder(
                ((BigDecimal)bwo.get("BOOKINGID")).intValue(),
                (String)bwo.get("WORKORDERID"),
                ((BigDecimal)bwo.get("BOOKINGWOID")).intValue()
            );
        }
        return bwos;
    }
}