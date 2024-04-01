package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.jayesh.condb.JayShreeRam;

/**
 * Servlet implementation class Checkout
 */
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			
			Connection con=(Connection) JayShreeRam.connect();
			String name=request.getParameter("name");
			String mobile=request.getParameter("mobile");
			String landmark=request.getParameter("landmark");
			String city=request.getParameter("city");
			String address=request.getParameter("address");
			java.sql.PreparedStatement ps1=con.prepareStatement("insert into check_add values(?,?,?,?,?)");
			ps1.setString(1,name);
			ps1.setString(2,mobile);
			ps1.setString(3, landmark);
			ps1.setString(4, city);
			ps1.setString(5, address);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println(" Address upload Successfully...");
				response.sendRedirect("payment.html");
			}
			else
			{
				System.err.println("Registration Failed..!!");
			}
			response.sendRedirect("checkout.html");
			
			
			
		}
		catch(Exception  e)
		{
			e.printStackTrace();
			
		}
	}

}
