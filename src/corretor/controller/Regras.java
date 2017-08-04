package corretor.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regras {
	
	List<String> erros = new ArrayList<String>();
	List<String> erros2 = new ArrayList<String>();

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
		//System.out.println(matcher);
		while (matcher.find()) {
			count++;
			//System.out.println("Você tem "+count+" ocoência de espaço antes de . ou ,");
			//System.out.println(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
			erros.add(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
		}
		return erros;
	}
	
	public List<String> getLista(){
		return erros;
	}

	
	public List<String> encontrarDoisPontos(String texto){
		
		int tam = texto.length();
		for(int i=0; i<tam;i++){
			if((texto.charAt(i) == ':') && (Character.isSpaceChar(texto.charAt(i+1)) && (Character.isUpperCase(texto.charAt(i+2))))){
				//System.out.println(texto.charAt(i) +" <-i e i+50 ->"+texto.charAt(i+2));
				//System.out.println("deposi dos dois pontos é letra minúscula");
				String p = texto.substring(i, i+50);
				//System.out.println(p);
				erros.add(p);
				
			}
		}
		return erros;
	}
	
	public List<String> espacoParentese(String texto){
		
		
    	String regex = "(\\w)([\\(])";

    	int count = 0;
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		//System.out.println(matcher);
		while (matcher.find()) {
			count++;
			//System.out.println("Você tem "+count+" ocoência de espaço antes de . ou ,");
			//System.out.println(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
			erros.add(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
		}
		return erros;
	}
	
	public List<String> espacoCitacao(String texto){
		
		
    	String regex = "(\\w)(\\\\(cite)\\{)";

    	int count = 0;
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		//System.out.println(matcher);
		while (matcher.find()) {
			//count++;
			//System.out.println("Você tem "+count+" ocoência de espaço antes de . ou ,");
			//System.out.println(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
			erros.add(texto.substring((matcher.end(1)), (matcher.end(1)+50)));
		}
		return erros;
	}
	
}
