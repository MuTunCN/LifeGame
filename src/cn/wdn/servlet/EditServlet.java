package cn.wdn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wdn.dao.DataDao;
import cn.wdn.dao.Impl.DataDaoImpl;
import cn.wdn.model.Data;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
	HttpServletRequest request;
	HttpServletResponse response;
	DataDao dao = new DataDaoImpl();
	HttpSession session;
	int id ,age;
	String content,shortCon,title,attr,toPage;
	boolean buff;
	boolean flag=false;					//操作后的重调用的判断条件
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		this.request = request;
		this.response = response;
		String action = request.getParameter("action");
		if(action==null||flag==true){
			action = "getAlldata";
		}
		switch(action){
		case "getDataById":
			getDataById();
			break;
		case "getAlldata":
			getAlldata();
			break;
		case "getDataByAge":
			 getDataByAge();
			break;
		case "getDataByAttr":
			getDataByAttr();
			break;
		case "getDataByBuff":
			getDataByBuff();
			break;
		case "delete":
			delete();
			break;
		case "modify":
			modify();
			break;
		case "insert":
			insert();
			break;
		}
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void getDataById() {
		id = Integer.parseInt(request.getParameter("id"));
		List<Data> list = dao.getDataById(id);
		session.setAttribute("mList", list);
		toPage = "Edit.jsp";
	}

	private void insert() {
		age = Integer.parseInt(request.getParameter("age"));
		content = request.getParameter("content");
		shortCon = request.getParameter("shortCon");
		title = request.getParameter("title");
		attr = request.getParameter("attr");
		String chk = request.getParameter("buff");
		if(chk!=null){
			buff = true;
		}else{
			buff = false;
		}
		Data data = new Data(age, content, shortCon, title, attr, buff);
		flag = dao.Insert(data);
		if(flag){
			toPage = "editServlet";
		}else{
			toPage = "Error.jsp";
		}
		
	}

	private void modify() {
		id = Integer.parseInt(request.getParameter("id"));
		age = Integer.parseInt(request.getParameter("age"));
		content = request.getParameter("content");
		shortCon = request.getParameter("shortCon");
		title = request.getParameter("title");
		attr = request.getParameter("attr");
		String[] chk = request.getParameterValues("buff");
		if(chk!=null){
			buff = true;
		}else{
			buff= false;
		}
		Data data = new Data(id,age, content, shortCon, title, attr, buff);
		flag = dao.Modify(data);
		if(flag){
			session.setAttribute("mList", null);
			toPage = "editServlet";
		}else{
			toPage = "Error.jsp";
		}
		
	}

	private void delete() {
		id = Integer.parseInt(request.getParameter("id"));
		flag = dao.Delete(id);
		if(flag){
			
			toPage = "editServlet";
		}else{
			toPage = "Error.jsp";
		}
		
		
	}

	private void getDataByBuff() {
		String[] chk = request.getParameterValues("buff");
		if(chk.equals("true")){
			buff = true;
		}else{
			buff= false;
		}
		List<Data> list = dao.getDataByBuff(buff);
		session.setAttribute("list", list);
		toPage = "Edit.jsp";
	}

	private void getDataByAttr() {
		attr = request.getParameter("attr");
		List<Data> list = dao.getDataByAttr(attr);
		session.setAttribute("list", list);
		toPage = "Edit.jsp";
	}

	private void getDataByAge() {
		age = Integer.parseInt(request.getParameter("age"));
		List<Data> list = dao.getDataByAge(age);
		session.setAttribute("list", list);
		flag = true;
		toPage = "Edit.jsp";
	}

	private void getAlldata() throws ServletException, IOException {
		flag = false;
		List<Data> list = dao.getAlldata();
		session.setAttribute("list", list);
		toPage = "Edit.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
