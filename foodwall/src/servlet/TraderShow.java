package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cloudshow.FoodWall;

public class TraderShow extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=request.getParameter("cid");
		int[] traderlist=FoodWall.listTradersByuid(cid);
		JSONObject json = new JSONObject();
		json.put("ids", traderlist);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	


}
