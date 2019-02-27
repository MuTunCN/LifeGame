package cn.wdn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MiddleServlet
 */
@WebServlet(name="MiddleServlet",urlPatterns="/middleServlet")
public class MiddleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;  
	private String name;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取姓名
		name = request.getParameter("name");
		//把姓名放到session中
		session = request.getSession();
		session.setAttribute("name", name);
		//根据是否是admin将数据转发到其他servlet
		if(name.equalsIgnoreCase("admin")){
			request.getRequestDispatcher("editServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("mainServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
