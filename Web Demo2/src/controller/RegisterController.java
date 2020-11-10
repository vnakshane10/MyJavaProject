package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String LoginId=request.getParameter("loginId");
		String Password=request.getParameter("passwd");
		String CustomerName=request.getParameter("customerName");
		String EmailId=request.getParameter("emailId");
		String Mobile=request.getParameter("mobileNo");
		String Address=request.getParameter("addr");
		String Country=request.getParameter("country");
		
		model.User userObj=new model.User();
		userObj.setLoginId(LoginId);
		userObj.setPassword(Password);
	     userObj.setEmailId(EmailId);
	     userObj.setCustomerName(CustomerName);
		 userObj.setMobile(Mobile);
	     userObj.setAddress(Address);
	     userObj.setCountry(Country);
	     
	   try
	     {
	    		 dao.UserDAO userDAO=new dao.UserDAO();
	    		   if(userDAO.insertCustomer(userObj))
	    		   {
	    			   request.setAttribute("LoginId", LoginId);
	    			   RequestDispatcher dispatcher=request.getRequestDispatcher("Success.jsp");
	    			   dispatcher.forward(request, response);
	    	 }
	    		   else
	    		   {
	    			   request.setAttribute("errorInfo"," Problem occured While inserting");
	    			   RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
	    			   dispatcher.forward(request, response);
	    		   }
	    }
	     catch(Exception e)
	     {
	    	 System.out.println("Exception Arised"+e);
	    	 request.setAttribute("error info", "Exception occured While inserting:"+e.getMessage());
	    	 RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
			   dispatcher.forward(request, response);
	     }
	     
	}

}