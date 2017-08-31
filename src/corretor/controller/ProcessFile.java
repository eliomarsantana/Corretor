package corretor.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ProcessFile
 */
@WebServlet("/ProcessFile")
public class ProcessFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String TEXTO_COMPLETO;
	public static String TEXTO_COMPLETO_SEM_INCLUDE;
	private ServletFileUpload uploader = null;

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		


		request.removeAttribute("erros");
		request.removeAttribute("erros2");
		request.removeAttribute("erros3");
		request.removeAttribute("erros4");
		Util util = new Util();

		//String arquivo = request.getParameter("arquivo");
		
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				
				Path caminho = Paths.get(System.getProperty("user.dir"), fileItem.getName());
				Stream<String> linhas = Files.lines(caminho);
				
				//File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				//File diretorioPrincipal = new File(fileItem.getName());
				String dp = request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName();
				//String uridp = dp.toUri().toString();
				if (fileItem.getName().endsWith(".tex")) {
					
					

					String dados = fileItem.getString();//new String(Files.readAllBytes(new File("arquivo").toPath()));

					TEXTO_COMPLETO = util.retiraCaracterEspecial(util.UTF8toISO(dados));
					
				
					FileTypeBuilder flb = new LatexConcreteBuilder();
					Text text = flb.createText();
					Abstract r = flb.createAbstract(TEXTO_COMPLETO);
					Title t = flb.createTitle(TEXTO_COMPLETO);
					Section s = flb.createSection(TEXTO_COMPLETO);
					text.setResumo(r);
					text.setTitulo(t);
					//text.mountText();
					
					
			  		

					TEXTO_COMPLETO_SEM_INCLUDE = text.mountText();;

					
					String regex = "\\\\input\\{(?<texto>.*?)\\}";

					Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(TEXTO_COMPLETO);
					
					while (matcher.find()) {
						String input = matcher.group("texto");

						
						String sections = new String(Files.readAllBytes(new File(dp+input).toPath()));

						String sections2 = util.retiraCaracterEspecial(util.UTF8toISO(sections));
						String inputSection2 = "";
						Matcher matcher2 = pattern.matcher(sections2);
						
						while (matcher2.find()) {
							
							String input2 = matcher.group("texto");
	
						
							String inputSection = new String(Files.readAllBytes(new File(dp+input2).toPath()));
							
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
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public List<String> getLista() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.virgulaPonto(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista2() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.encontrarDoisPontos(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista3() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.espacoParentese(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	public List<String> getLista4() {
		Regras r = new Regras(TEXTO_COMPLETO_SEM_INCLUDE);
		List<String> e = r.espacoCitacao(TEXTO_COMPLETO_SEM_INCLUDE);
		return e;
	}

	private byte[] read(FileItem fi) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = fi.getInputStream();
		int read = 0;
		final byte[] b = new byte[1024];

		while ((read = is.read(b)) != -1) {
			out.write(b, 0, read);
		}
		return out.toByteArray();
	}

}
