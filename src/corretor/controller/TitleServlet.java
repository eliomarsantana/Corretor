package corretor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import corretor.builders.LatexConcreteBuilder;
import corretor.interfaces.FileTypeBuilder;
<<<<<<< HEAD
import corretor.regras.Regras;
=======
>>>>>>> 5478797a2f06392f60af50417dc673ca0d3a00a0

/**
 * Servlet implementation class TitleServlet
 */
@WebServlet("/TitleServlet")
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	
<<<<<<< HEAD
    	Regras regras = new Regras();
    	
    	System.out.println("Chegou na servlet Title");
    	
    	String sessao = (String)session.getAttribute("dados");
    	
    	FileTypeBuilder flb = new LatexConcreteBuilder();
		
    	flb.createTitle().setTitle(sessao);
		
		//regras.countCharacters(flb.createTitle().getTitle());
    	
    	request.getRequestDispatcher("/ResumeServlet").forward(request, response);
=======
    	System.out.println("Chegou na servlet Title");
    	String sessao = (String)session.getAttribute("dados");
    	FileTypeBuilder flb = new LatexConcreteBuilder();
		flb.createTitle().setTitle(sessao);
		System.out.println(flb.createTitle().getClass().getName());
		System.out.println(sessao);
    	
    	request.getRequestDispatcher("/index.jsp").forward(request, response);
>>>>>>> 5478797a2f06392f60af50417dc673ca0d3a00a0
    }
	
	

}