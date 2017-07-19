package corretor.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jbibtex.ParseException;

import corretor.builders.LatexConcreteBuilder;
import corretor.interfaces.FileTypeBuilder;
import corretor.regras.Regras;
import corretor.regras.Util;

/**
 * Servlet implementation class ProcessFile
 */
@WebServlet("/ProcessFile")
public class ProcessFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Util util = new Util();
    	
    	String arquivo = request.getParameter("arquivo");
    	
    	
    	String diretorioPrincipal = arquivo.split("main.tex")[0];
    	
    	
		String dados = new String(Files.readAllBytes(new File(arquivo).toPath()));
		String dados2 = util.charset(dados);
		try {
			System.out.println(util.extractText(dados2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		int count = 0;
		//MONTANDO O TEXTO NA ORDEM EM UMA �NICA STRING
		String regex = "\\\\input\\{(?<texto>.*?)\\}";
		
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(dados2);
		while (matcher.find()) {
			String title = matcher.group("texto");
			System.out.println(title);
			
			
			String sections = new String(Files.readAllBytes(new File(diretorioPrincipal+title).toPath()));
			
			
			
			String sections2 = util.charset(sections);
			System.out.println(sections2);
			
			File arquivos = new File(diretorioPrincipal+title);
			
			//System.out.println("URL: "+url.toString());
			String linha = "";
			BufferedReader br = new BufferedReader(new FileReader(arquivos));
			while(br.ready()){
			   linha = br.readLine();
			   String linha2 = util.charset(linha);
				
				try {
					System.out.println(util.extractText(linha2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			br.close();
			
		
		
		}
		
			//LIMITANDO PARA TESTE
			/*
				try {
					System.out.println(util.extractText(sections2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			

			
			
			
			
		}
	
		
		/*
		//session.setAttribute("dados", dados);
		
		
		//FileTypeBuilder flb = new LatexConcreteBuilder();
		//flb.createTitle().setTitle(dados);
		//flb.createResumo().setText(dados);
		Regras r = new Regras();
		
		int qtdCit = (int)r.countCitations(dados);
		if(qtdCit <= 3){
			System.out.println("Vc precisa de mais cita��es");
		}
		System.out.println("Cita��es: "+ new Regras().countCitations(dados));
		
		FileTypeBuilder flb = new LatexConcreteBuilder();
		//flb.createResumo().setText(dados);

		
		//request.getRequestDispatcher("/TitleServlet").forward(request, response);
   	*/	
		
    
}
