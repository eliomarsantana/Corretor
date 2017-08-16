package corretor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regras {

	List<String> erros = new ArrayList<String>();

	public Object countCharacters(String texto) {
		int cont = 0;
		int tamanhoVetor = texto.length();
		for (int i = 0; i < tamanhoVetor; i++) {
			if (!Character.isSpaceChar(texto.charAt(i))) {
				cont++;
			}
		}
		return cont;
	}

	public Object countCitations(String texto) {
		int count = 0;
		String title = "\\\\(cite)\\{";

		Pattern pattern = Pattern.compile(title, Pattern.CASE_INSENSITIVE);
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

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
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

	public List<String> virgulaPonto(String texto) {

		String regex = "(\\w)(\\s+)([\\.,])";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		while (matcher.find()) {
			erros.add((texto.substring((matcher.start(0)-20),(matcher.end(0))))+"<font face=\"arial\" size=2 style=\"background-color: #FFFF00\">"+(texto.substring((matcher.start(1)+3), (matcher.end(1)+5))+"</font>")+(texto.substring((matcher.start(1)+6), (matcher.end(1)+20))));
		}
		return erros;
	}

	public List<String> getLista() {
		return erros;
	}

	public List<String> encontrarDoisPontos(String texto) {

		int tam = texto.length();
		for (int i = 0; i < tam; i++) {
			if ((texto.charAt(i) == ':') && (Character.isSpaceChar(texto.charAt(i + 1)) && (Character.isUpperCase(texto.charAt(i + 2))))) {

				erros.add(texto.substring(i-20, i - 1)+"<font face=\"arial\" size=2 style=\"background-color: #FFFF00\">"+texto.substring(i, i + 5)+"</font>"+texto.substring(i+5,i+20));

			}
		}
		return erros;
	}

	public List<String> espacoParentese(String texto) {

		int tam = texto.length();
		for (int i = 0; i < tam; i++) {
			if ((texto.charAt(i) == '(') && (!Character.isSpaceChar(texto.charAt(i - 1)))) {

				erros.add(texto.substring(i-20, i - 1)+"<font face=\"arial\" size=2 style=\"background-color: #FFFF00\">"+texto.substring(i, i + 5)+"</font>"+texto.substring(i+5,i+20));

			}
		}
		return erros;
	}

	public List<String> espacoCitacao(String texto) {

		String regex = "(\\w)(\\\\(cite)\\{)";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		while (matcher.find()) {
			erros.add((texto.substring((matcher.start(0)-20),(matcher.end(1)))+"<font face=\"arial\" size=2 style=\"background-color: #FFFF00\">"+(texto.substring((matcher.start(1)+1),(matcher.start(1)+6))+"</font>"+(texto.substring((matcher.start(1)+6),(matcher.start(1)+20))))));
		}
		return erros;
	}

}
