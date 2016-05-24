package service.impl;

import java.util.ArrayList;

import mock.CommentMock;
import mock.CustomerMock;

import pojo.Comment;
import pojo.Customer;
import service.CommentService;

public class CommentServiceimpl implements CommentService {
	
	private static ArrayList<Comment> comments = new ArrayList<Comment>();

	public static ArrayList<Comment> getComments() {
		return comments;
	}

	public static void setComments(ArrayList<Comment> comments) {
		CommentServiceimpl.comments = comments;
	}

	public ArrayList<Comment> checkComments(int pid) {
		comments = CommentMock.trlist;
		for (Comment temp : comments) {
			if (temp.getCommentid() == pid) {
				return comments;
			}
		}
		return null;
	}

	public int addComment(Comment c) {
		comments=CommentMock.trlist;
		comments.add(c);
		return 1;
	}

	public Comment findCommentById(Integer commentid) {
		comments = CommentMock.trlist;
		for (Comment temp : comments) {
			if (temp.getCommentid() == commentid) {
				return temp;
			}
		}
		return null;
	}

}
