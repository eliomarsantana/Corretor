package corretor.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section {

	public Section(String text){
		
	}
	
	public void setSection(String text) {

		Matcher matcher = PATTERN.matcher(text);

		if (matcher.matches() && matcher.groupCount() == 1) {
			this.text = matcher.group(1);
		} else {
			System.out.println("Não encontrou resumo.");
		}

	}

	
	public void setTitleSection(String text) {

		String regex = "\\\\section\\{(?<titulo>.*?)\\}";

		String title = text.replace("\\", "\\\\");//escapando as barras no arquivo
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(title);
		
		if (comparator.find()) {
			this.title = comparator.group("titulo");
		}
	}
	
	
	private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*");

	private String title;
	private Section[] subsections;
	private String text;
}
