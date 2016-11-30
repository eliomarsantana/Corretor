package corretor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Title {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String texto) {

		String regex = "\\\\title\\{(?<meuTitulo>.*?)\\}";

		String title = texto.replace("\\", "\\\\");//escapando as barras no arquivo
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(title);
		
		if (comparator.find()) {
			this.title = comparator.group("meuTitulo");
		}
	}
}
