<%@ page language="java" import="java.util.*,java.sql.Connection,
java.sql.DriverManager,java.sql.ResultSet
,java.sql.SQLException,java.sql.Statement" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String name=" " ; String pass=" ";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    github test test 2<br>123132146546<br>
 <%
		Connection conn =null;
		String url="jdbc:mysql://localhost:3306/test?user=root&password=&useUnicode=true&characterEncoding=UTF8";
		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			System.out.println("成功加载MySQL驱动程序");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("学号\t姓名");
			while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                name = rs.getString(1);
                pass = rs.getString(2);
            }
		} catch (SQLException e) {
			 System.out.println("MySQL操作错误");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
%>
<br>user=<%=name %>
<br>pass=<%=pass %>
  
  </body>
</html>
