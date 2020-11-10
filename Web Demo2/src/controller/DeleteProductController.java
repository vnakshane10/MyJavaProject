package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		int productId=Integer.parseInt(request.getParameter("productid"));
		try
		{
			dao.ProductDAO productDAO=new dao.ProductDAO();
			if(productDAO.deleteProduct(productId))
			{
				request.setAttribute("productlist", productDAO.getProductList());
					RequestDispatcher dispatcher=request.getRequestDispatcher("ProductDisplay.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("errorInfo","Problem Occured While Inserting Product");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
					dispatcher.forward(request, response);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
				request.setAttribute("errorInfo","Problem Occured While Inserting"+e.getMessage());
				RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}


