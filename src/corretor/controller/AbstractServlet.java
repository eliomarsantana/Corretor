package corretor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AbstractServlet
 */
@WebServlet("/AbstractServlet")
public class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = arg0.getSession();
		
		
		
		FileTypeBuilder flb = new LatexConcreteBuilder();
  		//Abstract r = flb.createAbstract(text);

  		//System.out.println(r.getResumo());
  		
  		System.out.println(flb.createText().getResumo());
  		
	}

}
