package action;

import java.util.ArrayList;

import pojo.Comment;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.impl.CommentServiceimpl;


public class CommentAction extends ActionSupport{
	private static CommentServiceimpl csi=new CommentServiceimpl();
    private int pid;
	private Comment comment;
	private int commentid;
	
    public String checkComments(){
    	ArrayList<Comment>  comments=csi.checkComments(pid);
		ActionContext.getContext().put("p_comments", comments);
		return SUCCESS;
	}
	
    public String addComment() {
		int m=csi.addComment(comment);
		if(m>0){
			return SUCCESS;
		}
		return ERROR;
	}

    public String findCommentById() {
		Comment com=csi.findCommentById(commentid);
		ActionContext.getContext().put("comment", com);
		return SUCCESS;	
		
	}

}
