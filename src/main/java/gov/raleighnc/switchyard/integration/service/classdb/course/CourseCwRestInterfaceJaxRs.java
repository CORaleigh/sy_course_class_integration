package gov.raleighnc.switchyard.integration.service.classdb.course;

import gov.raleighnc.switchyard.integration.domain.cityworks.workorder.WorkOrder;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Switchyard "Reference Binding" implementation to communicate to the Cityworks integration services directly via JaxRS.
 * 
 * @author mikev
 *
 */
@Path("/")
public interface CourseCwRestInterfaceJaxRs {
	@POST
    @Path("/createwo")
    @Consumes({"application/json"})
    @Produces({"application/json"})
	String createWorkOrder(WorkOrder wo);
}