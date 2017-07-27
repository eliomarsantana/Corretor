package corretor.regras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regras {
	
	List<String> erros = new ArrayList<String>();

	public Object countCharacters(String texto) {
		int cont=0;
		int tamanhoVetor = texto.length();
		for(int i=0;i<tamanhoVetor;i++){
			if(!Character.isSpaceChar(texto.charAt(i))){
				cont++;
			}
		}
		return cont;
	}
	
	public Object countCitations(String texto) {
		int count = 0;
		String title = "\\\\(cite)\\{";
	    

		Pattern pattern = Pattern.compile(title,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		System.out.println(matcher);
		while (matcher.find()) {
			count++;
		}
		return count;

	}
	
	public Object countSubsection(String texto) {
		int count = 0;

		String regex = "\\\\(subsection)\\{";
	    
	    
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		System.out.println(matcher);
		while (matcher.find()) {
			count++;
		}
		return count;
	}
	
	public int countWords(String linha) {

		int numeropalavras = 0;
		int indice = 0;
		boolean espacoembranco = true;
		while (indice < linha.length()) {
			char c = linha.charAt(indice++);
			boolean espacoembrancoatual = Character.isWhitespace(c);
			if (espacoembranco && !espacoembrancoatual) {
				numeropalavras++;
			}
			espacoembranco = espacoembrancoatual;
		}
		return numeropalavras;
	}
	
	public List<String> virgulaPonto(String texto){
		
		
    	String regex = "(\\w)(\\s+)([\\.,])";

    	int count = 0;
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		System.out.println(matcher);
		while (matcher.find()) {
			count++;
			System.out.println("Você tem "+count+" ocoência de espaço antes de . ou ,");
			System.out.println(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
			erros.add(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
		}
		return erros;
	}
	
	public List<String> getLista(){
		return erros;
	}
	
}
