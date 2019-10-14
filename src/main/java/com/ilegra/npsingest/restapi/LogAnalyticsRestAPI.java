package com.ilegra.npsingest.restapi;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ilegra.npsingest.service.IngesterService;

@Path("/laar")
public class LogAnalyticsRestAPI {

	private static final Logger logger = Logger.getLogger(LogAnalyticsRestAPI.class.getName());
	
	@Path("/ingest")
	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.APPLICATION_JSON)
	public Response ingest(
			@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileInfo) {
		try {
			new IngesterService().ingest(file, fileInfo.getFileName());
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Error while trying to read the file",e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
