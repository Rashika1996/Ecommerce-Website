import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletEntries extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null,st2=null;
	ResultSet rs=null;
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");/* Loading Driver using this static class named Class*/
	  con=DriverManager.getConnection("jdbc:odbc:ECOM");
	}
    catch(ClassNotFoundException e1)
	{
	  out.println(e1);
	}
    catch(SQLException e2)
	{
	  out.println(e2);
	}
	String p=req.getParameter("k");
	
	String m="<html>"+
"<head>"+
"<title>Welcome</title>"+
"<link type='text/css' rel='stylesheet' href='Style1.css'>"+
"<link type='image/png' rel='icon' href='favicon.png'>"+
"<script language='javascript' >"+
"function f1()"+
"{"+
"var w=window.open('Login.html','','width=500 height=200 top=200 left=500 menubar=no toolbar=no');"+
"}"+
"</script>"+
"</head>"+

"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store </div>"+
"<div class='hr'> "+
"<a href='signup.html'><img src='images/signup.png' onMouseOver='src='images/signup-hover.png'' onMouseOut='src='images/signup.png''></a>"+
"<img src='images/login.png' onMouseOver='src='images/login-hover.png'' onMouseOut='src='images/login.png'' onClick='return f1();'>"+
"<a href='Aboutus.html'><img src='images/about-us.png' onMouseOver='src='images/about-us-hover.png'' onMouseOut='src='images/about-us.png''></a>"+
"<a href='ServletContactUs'><img src='images/contact-us.png' onMouseOver='src='images/contact-us-hover.png'' onMouseOut='src='images/contact-us.png''></a>"+
"</div>"+
"</div></header>"+
"<div class='image'><img src='images/signupmobile.png'></div>"+
"<div class='container'>"+
"<div class='heading'>SIGN UP</div>"+
"<form method='get' name='signup' action='ServletSignUp'>"+
"<input type='text' placeholder='  Name' value='' name='t1' ><br>"+
"<input type='email' placeholder='  Email' value='' name='t2' ><br>";
out.println(m);

if(p!=null)
{
m="<font color='red'>\"This mail is already taken\"</font><br> ";
out.println(m);
}
m="<input type='password' placeholder='  Password' value='' name='t3' ><br>"+
"<input type='number' placeholder='  Contact' value='' name='t4' ><br>"+
"<input type='text' placeholder='  City' value='' name='t5' ><br>"+
"<input type='text' placeholder='  Address' value='' name='t6'><br>"+
"<input type='submit' value='' name='b1'><br>"+
"</form>"+
"</div>"+
"<footer>"+
"<div class='fmid'>"+
	"<div class='f1'>"+
		"<div class='heading1'>Information</div>"+
		"<div class='disp1'><div class='r1'>About Us Contact Us</div></div>"+
		"</div>"+
	"<div class='f2'>"+
		"<div class='heading1'>My Account</div>"+
		"<div class='disp1'><div class='r1'>Login SignUp</div></div>"+
		"</div>"+
	"<div class='f3'>"+
	"<div class='heading1'>Contact Us</div>"+
	"<div class='disp1'>Contact +91-123-000000</div>"+
	"</div>"+
"</div>"+
"</footer>"+

"</body>"+
"</html>";
out.println(m);
  }
}
