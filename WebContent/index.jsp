<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LifeGame</title>
        <link rel="stylesheet" href="assets/css/amazeui.min.css" />
        <link rel="stylesheet" href="assets/css/admin.css">
        <link rel="stylesheet" href="assets/css/index.css">
    </head>
    <body>
        <div class="header">
            <div class="am-g">
                <h1>Life Game</h1>
                <p>人生事件的随机模拟游戏</p><br>
                <p>请输入名字开始游戏</p>
                <p class="am-article-meta">输入admin可进入编辑界面</p>
            </div>
            <hr />
        </div>
        <div class="am-g">
            <div class="am-u-md-8 am-u-sm-centered">
                <form action="middleServlet" method="get"class="am-form">
                    <fieldset class="am-form-set">
                        <input type="text" placeholder="取个名字" name="name">
                    </fieldset>
                    <br>
                    <button type="submit" class="am-btn am-btn-primary am-btn-block">Link Start!!</button>
                </form>
            </div>
        </div>
        <p  class="am-article-meta" align="center">UI界面使用的是Amaze UI开源 HTML5 跨屏前端框架</p>
    </body>
</html>