package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String loginId=request.getParameter("loginId");
	String password=request.getParameter("passwd");
	
    model.User userobj=new model.User();	
	userobj.setLoginId(loginId);
	userobj.setPassword(password);
	try
	{
	dao.UserDAO userDAO=new dao.UserDAO();
	model.User tempUser=userDAO.checkLogin(userobj);

	if(tempUser !=null) {
		request.setAttribute("loginId",loginId);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Success.jsp");
		dispatcher.forward(request,response);
	}
	else {
		request.setAttribute("errorInfo","Invalid Login ID & Password. Please reenter");
		RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
		dispatcher.forward(request,response);
	}
	}
   catch(Exception e)
	{
	   request.setAttribute("errorInfo","Exception Occured  While Inserting:"+e.getMessage());
	   RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
	   dispatcher.forward(request, response);
	}
	}
}
