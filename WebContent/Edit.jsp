<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeGame编辑界面</title>
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<style type="text/css">
#table
{
width:100%;
height:100%;
overflow: scroll
}
</style>
<script type="text/javascript">
	function click_search() {
		var select = document.getElementById("select").selectedIndex;
		var option = document.getElementsByTagName("option");

		var searchName = option[select].text;
		var searchValue = document.getElementById("text").value

		if (searchName == option[0].text) {
			window.location.href = 'editServlet?action=getDataByAge&age='
					+ searchValue;
		} else if (searchName == option[1].text) {
			window.location.href = 'editServlet?action=getDataByBuff&buff='
					+ searchValue;
		} else if (searchName == option[2].text) {
			window.location.href = 'editServlet?action=getDataByAttr&attr='
					+ searchValue;
		}

	}
	function click_searchAll() {
		window.location.href = 'editServlet?action=getAlldata';
	}
	function click_insert() {
		document.getElementById("insert").style.display = "block";
	}
	function click_back() {
		window.location.href ="index.jsp";
	}

</script>
</head>
<body>
	<div style="display: none;" id="insert">
		<form action="editServlet" method="get" class="am-form,am-form-inline">
			<input type="hidden" name="action" value="insert">
			 <label for="age">事件年龄：</label>
			 <input type="text" value="" name="age" id="age" placeholder="从0开始递增频率为3"> 
			 <label for="content">事件内容：</label>
			 <input type="text" value="" name="content" id="content" placeholder="当前岁数遇到的事件"> 
			 <label for="shortCon">事件内容缩略：</label>
			 <input type="text" value="" name="shortCon" id="shortCon" placeholder="事件的概括用于显示在总结"> 
			 <label for="title">事件内容称号：</label>
			 <input type="text" value="" name="title" id="title" placeholder="事件对应的称号"> 
			 <label for="attr">事件内容属性：</label>
			 <input type="text" value="" name="attr" id="attr" placeholder="事件归类">
			  <div class="am-checkbox">
      			<label>
        		<input type="checkbox" name="buff" id="buff" > 事件内容正负面(1/0=正/负)
      			</label>
    		</div>
			<p><input type="submit" value="提交" class="am-btn am-btn-primary" ></p>
			<hr/>
		</form>
	</div>
	<c:if test="${!empty sessionScope.mList }">
		<form action="editServlet" method="get" class="am-form,am-form-inline" >
			<input type="hidden" name="action" value="modify">
			<label for="id">事件ID：</label>
			<input type="text" value="${sessionScope.mList[0].getId() }" name="id" readonly="readonly" id="id"  class="am-form-field">
			<label for="age">事件年龄：</label>
			<input type="text" value="${sessionScope.mList[0].getAge() }" name="age" id="age" placeholder="从0开始递增频率为3">
			<label for="content">事件内容：</label>
			<input type="text" value="${sessionScope.mList[0].getContent() }" name="content" id="content" placeholder="当前岁数遇到的事件">
			 <label for="shortCon">事件内容缩略：</label>
			<input type="text" value="${sessionScope.mList[0].getShortCon() }" name="shortCon" id="shortCon" placeholder="事件的概括用于显示在总结">
			<label for="title">事件内容称号：</label>
			<input type="text" value="${sessionScope.mList[0].getTitle() }" name="title" id="title" placeholder="事件对应的称号"> 
			 <label for="attr">事件内容属性：</label>
			<input type="text" value="${sessionScope.mList[0].getAttr() }" name="attr" id="attr" placeholder="事件归类">
			<div class="am-checkbox">
      			<label>
        		<input type="checkbox" name="buff"
				<c:if test ="${sessionScope.mList[0].getBuff()==true}"> checked="checked" </c:if>> 事件内容正负面(1/0=正/负)
      			</label>
    		</div>
			

			<input type="submit" value="submit" class="am-btn am-btn-primary">
			<hr/>
		</form>
	</c:if>
	<div id="table">
	<table width="100%" >
		<tr >
			<td><font size="4">Edit System</font></td>
			
			<td align="right"><select id="select">
					<option>年龄</option>
					<option>正负面</option>
					<option>属性</option>
			</select> <input type="text" value="" id="text" /> <input type="button"
				value="查询" onclick="click_search()" class="am-btn am-btn-success"/>
			<input type="button" value="查询所有" onclick="click_searchAll()" class="am-btn am-btn-danger"/>
				&nbsp;
				<button onclick="click_insert()" class="am-btn am-btn-warning">添加</button></td>
		</tr>
	</table>
	<table
		class="am-table am-table-bordered am-table-striped am-table-hover">
		<tr>
			<th>事件ID</th>
			<th>年龄</th>
			<th>事件内容</th>
			<th>事件内容缩略</th>
			<th>事件称号</th>
			<th>事件属性</th>
			<th>事件正负面</th>
			<th>删除事件</th>
			<th>修改事件</th>
		</tr>
		<c:forEach items="${sessionScope.list }" var="data">
			<tr>
				<td>${data.getId() }</td>
				<td>${data.getAge() }</td>
				<td>${data.getContent() }</td>
				<td>${data.getShortCon() }</td>
				<td>${data.getTitle() }</td>
				<td>${data.getAttr() }</td>
				<td>${data.getBuff() }</td>
				<td align="center"><button onclick="{location.href='editServlet?action=delete&id=${data.getId() }'}" class="am-btn am-btn-danger am-round" >删除</button></td>
				<td align="center"><button onclick="{location.href='editServlet?action=getDataById&id=${data.getId()}'}" class="am-btn am-btn-primary am-round" >修改</button></td>

			</tr>
		</c:forEach>
	</table>
	<div align="center">
	<button onclick="click_back()" class="am-btn am-btn-default"   style=" width:100%; ">返回</button>
	</div>
	</div>
</body>
</html>