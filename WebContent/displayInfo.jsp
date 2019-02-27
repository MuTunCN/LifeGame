<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,cn.wdn.model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeGame</title>
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<link rel="stylesheet" href="displayInfo.css">
<script src="assets/js/displayInfo.js"></script>

</head>
<script>
var count = 0;	
function click_next() {
    document.getElementById("header").style.display="none"
    var size = ${Slist.size() }
    if(count==size*3){
        document.getElementById("btn").value="end";
    }
    if(count==size*3&&document.getElementById("btn").value=="end"){
        var end = "${sessionScope.name }出生${Slist[0].getShortCon() }。一生里你经历过";
        end +="<c:forEach items='${Slist }' var='data' varStatus='stat'  ><c:if test='${!stat.last&&!stat.first}'>${data.getShortCon()}，</c:if></c:forEach>"
        end +="但不幸死于";
        end +="<c:forEach items='${Slist }' var='data' varStatus='stat'><c:if test='${stat.last}'>${data.getShortCon()}</c:if></c:forEach>";
        end +="享年";
        end +="<c:forEach items='${Slist }' var='data' varStatus='stat'><c:if test='${stat.last}'>${data.getAge()}</c:if></c:forEach>";
        end +="岁\n";
        end +="要不要再来一次";
        var r=confirm(end);
        if (r==true)
        {
            window.location.href='index.jsp';  
        }
        else
        {
           
        }
    }else{
    var i = count;
    var datas = new Array();
    var fnot = new Array();
    <c:forEach items="${Slist }" var="data">
    datas.push("${data.getAge()}","${data.getContent()}","${data.getTitle()}");
    </c:forEach>
    document.getElementById("age").innerHTML=datas[i]+'岁'
    document.getElementById('ul').innerHTML+="<li>"+"在"+datas[i]+"岁时，"+datas[i+1]+" &nbsp; <font color='blue'>获得称号：</font>"+
    "<font color='red'>"+datas[i+2]+"</font></li>";
    //alert(datas);
    //document.write("hello world");
    count = i+3;
    }
    
}
function click_back() {
    window.location.href ="index.jsp";
}
</script>
<body>
<div class="header" id="header">
  <div class="am-g">
    <h1>点击下一步开始模拟</h1>
    
  </div>
  <hr />
</div>


    <div class="am-panel am-panel-default">
        <div class="am-panel-hd">
   	        <h3 class="am-panel-title" id="age">请点击下一步</h3>
        </div>

        <ul class="am-list am-list-static" id = "ul">	
        </ul>
        <div class="am-panel-footer">
            <div class="am-cf">
			<input type="button" onclick="click_next()" value="下一步" id="btn" class="am-btn am-btn-secondary am-fl"/>
			<button onclick="click_back()" class="am-btn am-btn-default am-fr"   >返回</button>
			</div>
		</div>
	</div>


</body>
</html>