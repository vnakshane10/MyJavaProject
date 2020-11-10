package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName=request.getParameter("productName");
		String price=request.getParameter("price");
		String desc=request.getParameter("desc");
		String stock=request.getParameter("stock");
		String category=request.getParameter("category");
		String supplier=request.getParameter("supplier");
		
		model.Product productObj=new model.Product();
		
		productObj.setProductName(productName);
		productObj.setStock(Integer.parseInt(stock));
		productObj.setPrice(Integer.parseInt(price));
		productObj.setDescription(desc);
		productObj.setCategory(category);
		productObj.setSupplier(supplier);
		
		try
		{
			dao.ProductDAO productDAO=new dao.ProductDAO();
			if(productDAO.insertProduct(productObj))
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
