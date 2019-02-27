package cn.wdn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
 * Servlet implementation class MyServlet
 */
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String name;
	DataDao dao;
	private String content;
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		dao = new DataDaoImpl();
		List<Data> Slist = new ArrayList<Data>();		//最后随机出来的结果数组
		List<Data> Alist = dao.getAlldata();			//全部数据
		name = request.getParameter("name");
		List<List<Data>> list  = this.AgeList(Alist);	//根据年龄排序划分的数组
		for(int i=0;i<list.size();i++){//循环随机获取结果词条添加到结果数组里
			Random r = new Random();		
			int j = r.nextInt(list.get(i).size());
			Data data = list.get(i).get(j);
			content = name +data.getContent();
			data.setContent(content);
			if(data.getAttr().equals("die")){
				Slist.add(data);
				break;
			}
			Slist.add(data);
		}
		session.setAttribute("Slist", Slist);
		request.getRequestDispatcher("displayInfo.jsp").forward(request, response);
		
	}
	/**按照年龄分割
	 * 
	 * @param Alist 需要分割的数组
	 * @return
	 */
	
	public List<List<Data>> AgeList(List<Data> Alist){
		List<List<Data>> list = new ArrayList<List<Data>>();	
		List<Data> clist =null;
		Alist.sort(new Comparator<Data>() {				//重写排序使用年龄做比较对象

			@Override
			public int compare(Data o1, Data o2) {
				if(o1.getAge()<o2.getAge()){
					return -1;
				}else if(o1.getAge()>o2.getAge()){
					return 1;
				}else{
					return 0;
				}
			}
			
		});
		for (int i = 0; i <Alist.size(); i++) {		//按照年龄分割
			
			if(i==0){
				clist = new ArrayList<Data>();
			}
			if(i!=0&&Alist.get(i).getAge()!=Alist.get(i-1).getAge()){
				list.add(clist);
				clist = new ArrayList<Data>();
				
			} 
			if(i==Alist.size()-1){
				clist.add(Alist.get(i));
				list.add(clist);
				break;
			}
			clist.add(Alist.get(i));
		}
		return list;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
