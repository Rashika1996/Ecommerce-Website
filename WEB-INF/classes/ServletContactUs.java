import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletContactUs extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null;
	ResultSet rs=null;
	String r="<html>"+
"<head>"+
"<title>Contact us</title>"+
"<link type='text/css' rel='stylesheet' href='Style3.css'>"+
"<script language='javascript'>"+
"function f1()"+
"{var w=window.open('Login.html','','width=500 height=200 top=200 left=500 menubar=no toolbar=no');}"+
"</script>"+
"</head>"+
"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store </div>"+
"<div class='hr'>"+
"<a href='signup.html'><img src='images/signup.png' onMouseOver='src='images/signup-hover.png'' onMouseOut='src='images/signup.png''></a>"+
"<img src='images/login.png' onMouseOver='src='images/login-hover.png'' onMouseOut='src='images/login.png'' onClick='return f1();'>"+
"<a href='Aboutus.html'><img src='images/about-us.png' onMouseOver='src='images/about-us-hover.png'' onMouseOut='src='images/about-us.png''></a>"+
"<a href='ServletContactUs'><img src='images/contact-us.png' onMouseOver='src='images/contact-us-hover.png'' onMouseOut='src='images/contact-us.png''></a>"+
"</div>"+
"</div></header>"+
"<div class='container1'>"+
"<div class='h1'>"+
"<div class='h1a'>LIVE SUPPORT<br></div>"+
"<div class='h1c'>24 hours | 7 days a week | 365 days a year Live Technical Support<br></div>"+
"<div class='h1b'>This is a demo information. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.</div>"+
"</div>"+
"<div class='h2'><img src='images/callus.png'></div>"+
"</div>"+
"</div>"+
"<div class='container2'>"+
"<div class='h3'>"+
"<div class='h3a'>CONTACT US</div>"+
"<div class='h3b'>"+
"<form name='contact' method='get' action='ServletContactUs1'>"+
"<b>Name</b><br>"+
"<input type='text' value='' name='t1'><br>"+
"<b>Email:</b><br>"+
"<input type='email' value='' name='t2'><br>"+
"<b>Message:</b><br>"+
"<textarea cols='60' rows='7' name='tx1' value=' '></textarea><br>"+
"<input type='submit' value='' name='b1'>"+
"</form>"+
"</div>"+
"</div>";
out.println(r);

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
	try
	{
	 
	  st1= con.createStatement();
	  rs=st1.executeQuery("select * from CompanyAddress");
	  String Address="",Phone="",Fax="",Email="",FollowUs="";
	  if(rs.next())
	  {
		  Address=rs.getString(1);
		  Phone=rs.getString(2);
		  Fax=rs.getString(3);
		  Email=rs.getString(4);
		  FollowUs=rs.getString(5);
	  }
	 r="<div class='h4'>"+
"<div class='h4a'>Company Information :</div><br>"+
"<div class='h4b'>"+
Address+"<br>"+

"Phone:"+Phone+"<br>"+

"Fax:"+Fax+"<br>"+

"Email:"+Email+"<br>"+

"Follow on:"+FollowUs+
"</div>"+
"</div>"+
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
	"</div></div></footer></body></html>";
	out.println(r);

	   con.close();
	}
	 catch(SQLException e3)
	{
	  out.println(e3);
	}
	catch(Exception e4)
	{
	  out.println(e4);
	}
	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 doGet(req,res);
}
  
 }