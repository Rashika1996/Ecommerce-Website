import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletCart extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	HttpSession session=req.getSession();
	String email=(String)session.getAttribute("Email");
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
	String m="<html>"+
"<head>"+
"<title>Welcome</title>"+
"<link type='text/css' rel='stylesheet' href='Cart.css'>"+
"<link type='image/png' rel='icon' href='favicon.png'>"+
"</head>"+

"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store </div>"+
"<div class='hr'>"+
"<a href='ServletCart'><img src='images/cart.png' onMouseOver='src='images/cart-hover.png'' onMouseOut='src='images/cart.png''></a>"+
"<a href='ServletPasswordChange'><img src='images/settings.png' onMouseOver='src='images/settings-hover.png'' onMouseOut='src='images/settings.png''></a>"+
"<a href='ServletLogOut'><img src='images/logout.png' onMouseOver='src='images/logout-hover.png'' onMouseOut='src='images/logout.png' '></a>"+
"</div>"+
"</div>"+
"</header>"+
"<div class='items'>"+
"<table border='1' align='center' width='500' cell padding='3' >"+
"<tr>"+
"<td> SNo. </td><td>  Item Number   </td><td>  Price  </td><td> </td></tr>";

out.println(m);
try
{
	st=con.createStatement();
	rs=st.executeQuery("select * from Cart where Email='"+email+"'");
	String itemno="",price="";
	int SrNo=0;
	while(rs.next())
	{
		itemno=rs.getString(2);
		price=rs.getString(3);
		SrNo=rs.getInt(6);
	m="<tr><td>"+SrNo+"</td><td>"+itemno+"</td><td>"+price+"</td><td><a href='ServletRemove?rm="+SrNo+"'>Remove</a></td></tr>";
out.println(m);
	}
	 m="</table><div class='sub'><a href='productdelivered.html'><input type='submit' value='submit'></a></div></div></body></html>";
	 out.println(m);
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