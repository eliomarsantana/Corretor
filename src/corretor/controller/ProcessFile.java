package corretor.controller;

import java.io.File;
import java.io.IOException;
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

/**
 * Servlet implementation class ProcessFile
 */
@WebServlet("/ProcessFile")
public class ProcessFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 public ProcessFile() {
	        super();	        
	    }
	public static String TEXTO_COMPLETO;
	public static String TEXTO_COMPLETO_SEM_INCLUDE;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.removeAttribute("erros");
		request.removeAttribute("erros2");
		request.removeAttribute("erros3");
		request.removeAttribute("erros4");
		Util util = new Util();

		String arquivo = request.getParameter("arquivo");

		if (arquivo.endsWith(".tex")) {

			String diretorioPrincipal = arquivo.split("main.tex")[0];

			String dados = new String(Files.readAllBytes(new File(arquivo).toPath()));

			TEXTO_COMPLETO = util.retiraCaracterEspecial(util.UTF8toISO(dados));
			
			Resumo r = new Resumo();
			r.setResumo(TEXTO_COMPLETO);
			TEXTO_COMPLETO_SEM_INCLUDE = r.getResumo();

			int count = 0;
			String regex = "\\\\input\\{(?<texto>.*?)\\}";

			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(TEXTO_COMPLETO);
			while (matcher.find()) {
				String input = matcher.group("texto");

				String sections = new String(Files.readAllBytes(new File(diretorioPrincipal + input).toPath()));

				String sections2 = util.retiraCaracterEspecial(util.UTF8toISO(sections));
				String inputSection2 = "";
				Matcher matcher2 = pattern.matcher(sections2);
				while (matcher2.find()) {
					String input2 = matcher.group("texto");
					String inputSection = new String(
							Files.readAllBytes(new File(diretorioPrincipal + input2).toPath()));
					inputSection2 = util.retiraCaracterEspecial(util.UTF8toISO(inputSection));
					TEXTO_COMPLETO_SEM_INCLUDE = "/n" + TEXTO_COMPLETO_SEM_INCLUDE + inputSection2;
				}
				TEXTO_COMPLETO_SEM_INCLUDE = "/n" + TEXTO_COMPLETO_SEM_INCLUDE + sections2;

			}

			request.setAttribute("erros", getLista());
			request.setAttribute("erros2", getLista2());
			request.setAttribute("erros3", getLista3());
			request.setAttribute("erros4", getLista4());

			request.getRequestDispatcher("/lista.jsp").forward(request, response);

		} else {
			request.setAttribute("erro", "Somente upload de arquivo .tex");
			request.getRequestDispatcher("/erro.jsp").forward(request, response);

		}
	}

	public List<String> getLista() {
		Regras r = new Regras();
		List<String> e = r.virgulaPonto(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista2() {
		Regras r = new Regras();
		List<String> e = r.encontrarDoisPontos(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista3() {
		Regras r = new Regras();
		List<String> e = r.espacoParentese(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista4() {
		Regras r = new Regras();
		List<String> e = r.espacoCitacao(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

}
