<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page errorPage="error.jsp" %>
  <%@ include file="header.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Input Example with Scripting Elements</title>
</head>
<body>
    <h1>User Input Form</h1>
    
    <form action="">
       <label for="name">Name: </label>
       <input type="text" id="name" name="name" required><br><br>
       
       <label for="password">Password: </label>
       <input type="password" id="password" name="password"><br><br>
       
       <input type="submit"  value="submit">
       </form>
       
     <%!
         // Declaration Tag
         public boolean validUser(String name,String password){
    	   return name.equals("sarthak") && password.equals("1234");
     }
     %>
     
     
     <%
        //Scriptlet Tag
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        // Check if form is submitted.
        if(name != null && password != null){
        	if(validUser(name,password))   {
    
       %>
       
       <h2>Login Successfully: </h2>
       
       
       <!-- Expression Tag -->
       <p><b>Name: </b> <%= name %></p>
       <p><b>Password: </b> <%= password %></p>
       
       
       <!-- Expression Tag -->
       <p>Expression Example: 269 + 323 = <%= 269 + 323 %></p>
       
       
       
       <!-- Mixing Scripting Elements with HTML -->
      <table border="1">
         <tr>
           <th>Numbers</th>
           <th>Square</th>
         </tr>
         
         <%
           for(int i=1;i<=8;i++){
         %>  
         
        <tr>
           <td><%= i %></td>
           <td><%= i*i*i %></td>
        </tr>
        
        <%
           }
        %>   
       </table>
       
       
       
       <%
        	}else{
        		throw new RuntimeException();
        	}
        } else{
       %>
       
          <p>Please enter your information above!</p>
          
      <%
        } 
      %>    
        	
      
      
       
       
</body>
</html>