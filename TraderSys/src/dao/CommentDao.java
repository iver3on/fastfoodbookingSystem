package dao;
import java.util.*;

import pojo.Comment;
public class CommentDao {
	private static ArrayList<Comment> comments = new ArrayList<Comment>();

	public static ArrayList<Comment> getComments() {
		return comments;
	}

	public static void setComments(ArrayList<Comment> comments) {
		CommentDao.comments = comments;
	}
}
