
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Indexjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Indexjava() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cookies
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		out.println("User Name:"+username+"\nPassword:"+password);

		Cookie cookie=new Cookie("username",username);
		response.addCookie(cookie);
		response.sendRedirect("Servlet1");
		
		
		// URL Rewritting //
		
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url=request.getParameter("username");
		out.println("<a href='Servlet1?username="+url+"'>Click here</a>");
		out.close();
		}catch(Exception e) {e.printStackTrace();}
		RequestDispatcher rs=request.getRequestDispatcher("Servlet1");

		//Hidden Fields //

		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		
		out.print("<form action='Servlet1'>");
		out.print("<input type='hidden' User Name='username' value='"+username+"'>");
		out.print("<input type='submit'>");
		out.print("</form>");  
	    	out.close();  
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}