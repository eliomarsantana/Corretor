package corretor.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import corretor.builders.LatexConcreteBuilder;
import corretor.interfaces.FileTypeBuilder;

/**
 * Servlet implementation class ProcessFile
 */
@WebServlet("/ProcessFile")
public class ProcessFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	
    	String arquivo = request.getParameter("arquivo");
		String dados = new String(Files.readAllBytes(new File(arquivo).toPath()));
		
		session.setAttribute("dados", dados);
		
<<<<<<< HEAD
		//FileTypeBuilder flb = new LatexConcreteBuilder();
		//flb.createTitle().setTitle(dados);
		//flb.createResumo().setText(dados);
		
=======
		FileTypeBuilder flb = new LatexConcreteBuilder();
		flb.createResumo().setText(dados);
>>>>>>> 5478797a2f06392f60af50417dc673ca0d3a00a0
		
		request.getRequestDispatcher("/TitleServlet").forward(request, response);
   	
    }

}
