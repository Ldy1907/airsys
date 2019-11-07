<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*,util.*,servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出账号</title>
<link rel="stylesheet" href="/airsys/assets/css/main.css">
</head>
<body>
	<form action="listacts" method="get">
     <h3 align="center">账号信息</h3>
     <center>
     <table border="1">
         <tr>
             <th>账号</th>
             <th>姓名</th>
             <th>余额</th>
             <th>操作</th>
         </tr>
         <c:forEach items="${acts}" var="act">
         <tr>
             <td>${act.id}</td>
             <td>${act.name}</td>
             <td>${act.balance}</td>
             <td>
				<a href="user1/${act.id}">查看</a>
		        <a href="#" onclick="deleteUser(${act.id})">删除</a>
			    <a href="#" onclick="update(${act.id})">修改</a>          
             </td>
         </tr>
         </c:forEach>
     </table> 
	
     </center> 
     
     </form>      
     <script type="text/javascript" src="/airsys/assets/js/user.js"> </script>  
</body>
</html>

<!-- 
    路径正常为什么拿不到js和css文件
    路径都是http://locahost:8080/airsys02/assets/js/user.js
    因为SpringMVC它的原因造成的，DispacherServlet拦截“/”
   
    让SpringMVC中的核心的servlet不要拦截.js .css .jpg...
  
  怎么做呢？
   修改配置文件AppConfig
   
   Git
   	如何利用git开发项目，管理项目
   		Linux：[centos ubuntu/赛门铁克 solaries redhat 麒麟Linux]
   		
   		类Unix
   		花两周写这么个软件  版本控制软件，不过监控文本文件(word image video二进制文件)
   		源代码 xxx.java xxx.html xxx.css xxx.xml xxx.php xxx.py xxx.c xxx.cc xxx.js
   		
   	Git: 世界上最大的同性网站GitHub(项目源码)
   	
   	
   		
     
 -->
