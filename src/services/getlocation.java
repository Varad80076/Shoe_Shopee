package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayesh.condb.JayShreeRam;

/**
 * Servlet implementation class getlocation
 */
public class getlocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getlocation() {
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
		
		Connection con=JayShreeRam.connect();
		String message = null;
		
		
		try{
			int Id = getset.getCust_id();
			String Name=request.getParameter("name");
			String Address=request.getParameter("address");
			String Taluka=request.getParameter("taluka");
			String Lat=request.getParameter("lat");
			String Lng=request.getParameter("lng");
			
			
			PreparedStatement pstmt = con.prepareStatement("insert into buy (cust_id,name,address,Taluka,lat,lng) values (?,?,?,?,?,?)");
			pstmt.setInt(1, Id);
			pstmt.setString(2, Name);
			pstmt.setString(3, Address);
			pstmt.setString(4, Taluka);
			pstmt.setString(5, Lat);
			pstmt.setString(6, Lng);
			 int row = pstmt.executeUpdate();
             if (row > 0) {
                message = "File uploaded and saved into database";
                
                response.sendRedirect("shop.html");
             }
             
       	 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
		
		
	}

}
