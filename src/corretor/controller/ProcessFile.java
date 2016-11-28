package corretor.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    	String arquivo = request.getParameter("arquivo");
		String dados = new String(Files.readAllBytes(new File(arquivo).toPath()));

		FileTypeBuilder flb = new LatexConcreteBuilder();
		flb.createTitle().setTitle(dados);
		
    	
    }

}
