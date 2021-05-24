package co.edureka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uName = request.getParameter("userName");
		out.print("<h2>Welcome " + uName + "</h2>" );
		
		//Retrieve Cookies
		
		Cookie[] arrayOfCookieStores = request.getCookies();
		for(Cookie cookie: arrayOfCookieStores) {
			System.out.println("Cookie Name : " + cookie.getName() + 
					"Cookie Value : " + cookie.getValue());
			
			out.print("<h2>" + cookie.getName() + " >> " + cookie.getValue() + "</h2>");	
		}
		//Retrieving uname from URL -- URL Rewriting 
		String valueString = request.getParameter("uname");
		out.print("Displaying value from URL param - " + valueString);
		
		//Retrieving from HttpSession
		HttpSession httpSession = request.getSession();
		System.out.println(httpSession.getId());
		out.println("Session ID: " + httpSession.getId());
		httpSession.setAttribute("SecretInfo", valueString);
		out.println(httpSession.getAttribute("SecretInfo"));
		
		out.close();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
