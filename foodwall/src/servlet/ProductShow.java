package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cloudshow.FoodWall;

public class ProductShow extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		int tid=13579;
		int[] productlist=FoodWall.listproductbyuidandtid(cid, tid);
		JSONObject json = new JSONObject();
		json.put("ids", productlist);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();
		

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	public void init() throws ServletException {
	
	}

}
