import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletBuyNow extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	HttpSession session=req.getSession();
	String p=(String)session.getAttribute("Email");
	if(p==null)
		res.sendRedirect("Login.html");
	String h="<html>"+
"<head>"+
"<title>Welcome</title>"+
"<link type='text/css' rel='stylesheet' href='BuyNow.css'>"+
"<link type='image/png' rel='icon' href='favicon.png'>  <!--<link rel='icon' type='image/png' href=''>-->"+
"</head>"+

"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store welcomes "+p+" </div>"+
"<div class='hr'>"+ 
"<a href='#'><img src='images/cart.png' onMouseOver='src='images/cart-hover.png'' onMouseOut='src='images/cart.png'></a>"+
"<a href='settings.html'><img src='images/settings.png' onMouseOver='src='images/settings-hover.png'' onMouseOut='src='images/settings.png'></a>"+
"<a href='ServletLogOut'><img src='images/logout.png' onMouseOver='src='images/logout-hover.png'' onMouseOut='src='images/logout.png'></a>"+
"</div>"+
"</div></header> <!-- header section ends here -->"+
"<div class='row1'>"+
	"<div class='box'>"+
		"<div class='heading'>#1</div>"+
		"<div class='pic'><img src='images/pic1.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div>"+
	"<div class='box'>"+
		"<div class='heading'>#2</div>"+
		"<div class='pic'><img src='images/pic2.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div>"+
	"<div class='box'>"+
		"<div class='heading'>#3</div>"+
		"<div class='pic'><img src='images/pic3.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div></div>"+
	"<div class='row1'>"+
	"<div class='box'>"+
		"<div class='heading'>#4</div>"+
		"<div class='pic'><img src='images/pic4.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div>"+
	"<div class='box'>"+
		"<div class='heading'>#5</div>"+
		"<div class='pic'><img src='images/pic5.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div>"+
	"<div class='box'>"+
		"<div class='heading'>#6</div>"+
		"<div class='pic'><img src='images/pic6.png' height='100%'></div>"+
		"<div class='dis'>4.2' Screen, snap-dragon processor, 1GB RAM,4GB Internal memory, Rs 5000</div>"+
"<input type='button' value='Add to cart'>"+
	"</div>"+
"</div>"+
"</body>"+
"</html>";
out.println(h);

    	
	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 doGet(req,res);
}
  
 }