package edureka.assignment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayResultServlet
 */
@WebServlet("/success")
public class DisplayResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(
				"<h2><label style= \"color:green\">Provided User Name And Password are GOOD as per set rules.. Congratulations</label></br></h2>");
		response.getWriter().println(
				"<h3>Below dataset is extracted from the local storage~ cookies which were written after successful login by LoginServlet </h3><br/>");
		Cookie[] arrayOfCookieStores = request.getCookies();
		for(Cookie cookie: arrayOfCookieStores) {
			System.out.println("Cookie Name : " + cookie.getName() + 
					"Cookie Value : " + cookie.getValue());
			response.getWriter().print("<label style= \"color:green\">" + cookie.getName() + " | " + cookie.getValue() + "</label></br>");	
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
