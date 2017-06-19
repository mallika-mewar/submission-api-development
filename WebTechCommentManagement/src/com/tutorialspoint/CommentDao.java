package com.tutorialspoint;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CommentDao {

	private List<Comment> comments = new ArrayList<Comment>();
    
    private static CommentDao instance = new CommentDao();
    
    public CommentDao(){
    	try{
    		File file = new File("Comments.dat");
    		if(!file.exists()){
    			Comment cmt = new Comment(1, "Matthias","Ich bims 1 Informatiker vom Studium her","2017-06-13T10:00:00");
    			Comment cmt2 = new Comment(2, "Max","Hello WebTech2","2017-06-13T11:30:00");
    			Comment cmt3 = new Comment(3, "Tom","Here could be your advertisment","2017-06-13T12:15:00");
    			
    			comments.add(cmt);
    			comments.add(cmt2);
    			comments.add(cmt3);
    			saveCommentList(comments);
    		}else{
    			FileInputStream fis = new FileInputStream(file);
    			ObjectInputStream ois = new ObjectInputStream(fis);
    			comments = (List<Comment>) ois.readObject();
    			ois.close();
    		}
    	}catch (IOException e){
    		e.printStackTrace();
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}

    }
    
    private void saveCommentList(List<Comment> comments2) {
		try{
			File file = new File("Comments.dat");
			FileOutputStream fas;
			fas=new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fas);
			oos.writeObject(comments);
			oos.close();
		}catch (FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		
	}

	public static CommentDao getInstance(){
        return instance;
    }

	public List<Comment> getAllComments() {
		return comments;
	}

	public Comment getComment(int id){
		for(Comment c : this.getAllComments()){
			if(c.getId() == id){
				return c;
			}
		}
		return null;
	}
	
	public int addComment(Comment cmt){
		boolean cmtExist = false;
		for(Comment c : this.getAllComments()){
			if(c.getId() == cmt.getId()){
				cmtExist = true;
				break;
			}
		}
		
		if(!cmtExist){
			comments.add(cmt);
			this.saveCommentList(comments);
			return 1;
		}
		return 0;
	}
	
	public int updateComment(Comment cmt){
		for(Comment c : this.getAllComments()){
			if(c.getId() == cmt.getId()){
				int index = comments.indexOf(c);
				comments.set(index, cmt);
				return 1;
			}
		}
		return 0;
	}
	
	public int deleteComment(int id){
		for(Comment c : this.getAllComments()){
			if(c.getId() == id){
				int index = comments.indexOf(c);
				comments.remove(index);
				this.saveCommentList(comments);
				return 1;
			}
		}
		return 0;
	}
    
    
}
