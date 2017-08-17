package corretor.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titulo {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String text) {

		String regex = "\\\\title\\{(?<titulo>.*?)\\}";

		String title = text.replace("\\", "\\\\");//escapando as barras no arquivo
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(title);
		
		if (comparator.find()) {
			this.title = comparator.group("titulo");
		}
		System.out.println(getTitle()+"\n\n");
	}
}
