<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page errorPage="error.jsp" %>
 <%@ include file="header.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>User Input Form</h1>
      <form action="" method="post">
       <label for="name">Name: </label>
       <input type="text" id="name" name="name" required><br><br>
       
       <label for="password">Password: </label>
       <input type="password" id="password" name="password"><br><br>
       
       <input type="submit"  value="submit">
       </form>
       
       
     <% 
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        if(name != null && password != null){
        	boolean isValidUser = checkCredentials(name,password);
        	
        	if(isValidUser){
     %> 
     
             <h2>Login Successfully</h2>
             <p><b>Name: </b> <%= name %></p>
             <p><b>Password: </b> <%= password%></p>
             
             
             <p>Table of Square</p>
             <table border="1">
                <tr>
                   <th>Number</th>
                   <th>Square</th>
                </tr>
                
             <%
                for(int i=0;i<=5;i++){
             %>     
             
             <tr>
                <td><%= i %></td>
                <td><%= i*i %></td>
             </tr>
             
             <%
                }
             %>    
             </table>
             
             
             <p>Expression Example:239+232 = <%= 269 + 232 %></p>
             
             
           <%
        	}else{
        		out.println("<p>Invalid Credentiles!!!.Please try again.</p>");
        	}
               } else{
        	
           %>  
           
           <p>Please enter your information above.!</p>
           
           <%
               }
           %>
           
           
           <%! 
              public boolean checkCredentials(String username,String password){
        	   boolean isValid = false;
        	   try{
        	     Class.forName("com.mysql.cj.jdbc.Driver");
        	     java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","admin","admin");
        	     
        	     String query = "SELECT * FROM register WHERE username=? AND password=?";
        	     
        	     java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
        	     
        	     pstmt.setString(1, username);
        	     pstmt.setString(2, password);
        	     
        	     java.sql.ResultSet rs = pstmt.executeQuery();
        	     
        	     if(rs.next()){
        	    	 isValid = true;
        	     }
        	     rs.close();
        	     pstmt.close();
        	     conn.close();
        	   }catch(Exception e){
        		   e.printStackTrace();
        	   }
        	   
        	   return isValid;
           }
           %>
</body>
</html>