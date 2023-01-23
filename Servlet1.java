
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Cookies
		
		Cookie cookie[]=request.getCookies();
		PrintWriter out=response.getWriter();
		for(int i=0;i<cookie.length;i++) {
			out.write("Cookie Name: "+cookie[i].getName()+"<br>cookie Value: "+cookie[i].getValue());
                                                                                                   		}
		
		//URL Rewritting
		
	try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");

		out.println("<h1> HELLO "+username+"</h1>");
		out.close();}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		// Hidden Fields 

		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String hidden_username=request.getParameter("username");
		out.print("Hidden Value="+hidden_username);
		out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}