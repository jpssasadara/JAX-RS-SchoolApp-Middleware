package org.jps.sasadara.schoolApp.res;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jps.sasadara.schoolApp.models.Subject;
import org.jps.sasadara.schoolApp.services.SubjectService;


/**.\
 * Root resource (exposed at "myresource" path)
 */

@Path("subject")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Subject> getAllSub() {
    	return SubjectService.getSub();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Subject putSub(Subject sub) {
    	//return sub;
    	return SubjectService.insertSub(sub);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{subjectId}")
	public void updateSub(@PathParam("subjectId") String id, Subject sub) {
		sub.setSub_id(id);
		SubjectService.updateSub(sub);
		
	}
    
    @GET 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{subjectId}")
    public Subject getSelecSub(@PathParam("subjectId") String id) throws SQLException{
    	return SubjectService.getSelecSub1(id);
    }
    
    @DELETE
	@Path("/{subjectId}")
	public void deleteComment(@PathParam("subjectId") String id) throws SQLException {
    	SubjectService.DelSelecSub1(id);
    	System.out.println("sasa"+id);
	}
}
