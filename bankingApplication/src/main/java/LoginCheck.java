import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankingApplication.Credentials;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	static String actualPassword;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();

		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		Credentials cd = new Credentials();
		actualPassword = cd.getPassword(username);
		
		

		
		if(password.equals(actualPassword))
		{
			out.print("Login Successful");
			Cookie ck = new Cookie("name",username);
			
			response.addCookie(ck);
			String date = ck.getValue();
			request.getRequestDispatcher("viewAccounts.jsp").include(request, response);
			
		}
		else
		{
			out.print("Invalid username or password. Retry Login!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String uname =  request.getParameter("uname");
//		String password = request.getParameter("password");
//		if(uname.equals("Manas") && password.equals("Manas"))
//		{
//			response.sendRedirect("viewAccounts.jsp");
//		}
//		else
//		{
//			response.sendRedirect("login.jsp");
//		}
	}

}
