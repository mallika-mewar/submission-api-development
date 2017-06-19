package com.tutorialspoint;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;

@Path("/CommentService")
public class CommentService {

	CommentDao cmtDao = CommentDao.getInstance();
	
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";
	
	@GET
	@Path("/comments")
	@Produces(MediaType.APPLICATION_XML)
	public List<Comment> getComments(){
		return this.cmtDao.getAllComments();
	}
	
	@GET
	@Path("/comments/{commentid}")
	@Produces(MediaType.APPLICATION_XML)
	public Comment getComment(@PathParam("commentid")int id){
		return cmtDao.getComment(id);
	}
	
	@PUT
	@Path("/comments")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateComment(@FormParam("id") int id, @FormParam("author") String author, 
								@FormParam("message") String message, @FormParam("timeStamp") String timeStamp, 
								@Context HttpServletResponse servletResponse) throws IOException{
		Comment cmt = new Comment(id,author,message,timeStamp);
		int result = cmtDao.updateComment(cmt);
		if(result == 1){
			return SUCCESS_RESULT;
		}else{
			return FAILURE_RESULT;
		}
	}
	
	@POST
	@Path("/comments")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createComment(@FormParam("id") int id, @FormParam("author") String author, 
								@FormParam("message") String message, @FormParam("timeStamp") String timeStamp,
								@Context HttpServletResponse servletResponse) throws IOException{
		Comment cmt = new Comment(id,author,message,timeStamp);
		int result = cmtDao.addComment(cmt);
		if(result == 1){
			return SUCCESS_RESULT;
		}else{
			return FAILURE_RESULT;
		}
	}
	
	@DELETE
	@Path("/comments/{commentid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteComment(@PathParam("commentid") int id){
		int result = cmtDao.deleteComment(id);
		if(result == 1){
			return SUCCESS_RESULT;
		}else{
			return FAILURE_RESULT;
		}
	}
	
}
