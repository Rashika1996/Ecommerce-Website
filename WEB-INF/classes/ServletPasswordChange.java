import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletPasswordChange extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null;
	ResultSet rs=null;
	HttpSession session=req.getSession();
	String p=(String)session.getAttribute("Email");
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
	String k="";
 k=req.getParameter("k");
String m="<html><!-- This page will be made through servlet-->"+
"<head>"+
"<title>Welcome<br></title>"+
"<link type='text/css' rel='stylesheet' href='Style5.css'>"+
"<link type='image/png' rel='icon' href='favicon.png'>  <!--<link rel='icon' type='image/png' href=''>-->"+
"<script language='javascript'>"+
" function f1()"+
"{ "+
" var v1=document.forms[0].s2.value;"+
" var v2=document.forms[0].s3.value;"+
"if(v1!=v2)"+
"{"+
" alert('Password and Confirm password must be same');"+
" return(false);"+
"}"+
"return(true);"+
"}"+
"</script>"+
"</head>"+

"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store </div>"+
"<div class='hr'>"+
"<a href='ServletCart'><img src='images/cart.png' onMouseOver='src='images/cart-hover.png'' onMouseOut='src='images/cart.png''></a>"+
"<a href='ServletPasswordChange'><img src='images/settings.png' onMouseOver='src='images/settings-hover.png'' onMouseOut='src='images/settings.png''></a>"+
"<a href='ServletLogOut'><img src='images/logout.png' onMouseOver='src='images/logout-hover.png'' onMouseOut='src='images/logout.png''></a>"+
"</div>"+
"</div></header> <!-- header section ends here -->"+
"<div class='container'>"+
"<div class='h1'>Change Password</div>"+
"<div class='h2'>"+
"<form name='settings' method='get' action='ServletPasswordUpdated' onSubmit='return f1();'>"+
"<input type='password' value='' placeholder='old password' name='s1'><br>";
out.println(m);
if(k!=null && k.equals("2"))
{
m="<font color='red'>\"The password entered is incorrect\"</font>";
out.println(m);
}
m="<input type='password' value='' placeholder='new password' name='s2'><br>"+
"<input type='password' value='' placeholder='Re-type new password' name='s3'><br>";
out.println(m);
m="<input type='submit' value=''>";
out.println(m);
if(k!=null && k.equals("1"))
{
m="<font color='black'>\"Password Updated\"</font><br>";
out.println(m);
}
m="</form></div></div></body></html>";
out.println(m);
}
}