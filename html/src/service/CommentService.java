package service;

import java.util.ArrayList;

import pojo.Comment;



public interface CommentService {
	public ArrayList<Comment> checkComments(int pid); 
	public int addComment(Comment c);
	public Comment findCommentById(Integer commentid);
}
