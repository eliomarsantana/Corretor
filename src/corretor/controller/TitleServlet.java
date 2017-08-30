package corretor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TitleServlet
 */
@WebServlet("/TitleServlet")
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		
		
		FileTypeBuilder flb = new LatexConcreteBuilder();
		//Title t = flb.createTitle(text);
		//System.out.println("Título impresso na servlet");
		//System.out.println(t.getTitle());
		Text t = null;
		System.out.println(t.getTitulo());
		
		
		arg0.getRequestDispatcher("/AbstractServlet").forward(arg0, arg1);
	}

}
