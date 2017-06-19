package com.tutorialspoint;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class WebServiceTester {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/WebTechCommentManagement/rest/CommentService/comments";
	
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";
	
	private void init(){
		this.client = ClientBuilder.newClient();
	}
	
	public static void main(String[] args){
		WebServiceTester tester = new WebServiceTester();
		tester.init();
		tester.testGetAllComments();
		tester.testGetComment();
		tester.testUpdateComment();

		//for(int i = 1; i<10;i++){
			tester.testAddComment(4);
		//}
		
		tester.testDeleteComments();

	}

	private void testDeleteComments() {
		String callResult = client
				.target(this.REST_SERVICE_URL)
				.path("/{commentid}")
				.resolveTemplate("commentid", 2)
				.request(MediaType.APPLICATION_XML)
				.delete(String.class);
		String result = PASS;
		if(!SUCCESS_RESULT.equals(callResult)){
			result = FAIL;
		}
		System.out.println("Test case name: testDeleteComment, Result:" + result);
		
	}

	private void testAddComment(int id) {
		Form form = new Form();
		form.param("id", id+"");
		form.param("author", "Max");
		form.param("message", "WebTech2 is so awesome");
		form.param("timeStamp", "2017-06-13T20:00:00");
		String callResult = client
				.target(this.REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
		String result = PASS;
		if(!SUCCESS_RESULT.equals(callResult)){
			result = FAIL;
		}
		System.out.println("Test case name: testAddComment, Result:" + result);
		
	}

	private void testGetComment() {
		Comment sampleComment = new Comment();
		sampleComment.setId(1);
		Comment comment = (Comment) client
				.target(this.REST_SERVICE_URL)
				.path("/{commentid}")
				.resolveTemplate("commentid",4)
				.request(MediaType.APPLICATION_XML)
				.get(Comment.class);
		String result = FAIL;
		if(comment != null && sampleComment != null && sampleComment.getId() == comment.getId()){
			result = PASS;
		}
		System.out.println("Test case name: testGetComment, Result:" + result);
		
	}

	private void testUpdateComment() {
		Form form = new Form();
		form.param("id", "4");
		form.param("author", "Max");
		form.param("message", "Goodbye WebTech2");
		form.param("timeStamp", "2017-06-13T18:00:00");
		String callResult = client
				.target(this.REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
		String result = PASS;
		if(!SUCCESS_RESULT.equals(callResult)){
			result = FAIL;
		}
		System.out.println("Test case name: testUpdateComment, Result:" + result);
	}

	private void testGetAllComments() {
		GenericType<List<Comment>> list = new GenericType<List<Comment>>(){};
		List<Comment> comments = client
					.target(REST_SERVICE_URL)
					.request(MediaType.APPLICATION_XML)
					.get(list);
		String result = PASS;
		if(comments.isEmpty()){
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllComment, Result:" + result);
		
	}
	
}
