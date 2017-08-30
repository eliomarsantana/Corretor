package corretor.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Abstract {

	public Abstract(String text) {
		setResumo(text);
	}

	public String getResumo() {
		return text;
	}

	public void setResumo(String text) {
		

		String resume = text.replace("\\", "\\\\");// escapando as barras no
													// arquivo
		String t = resume.replace("\n", "\\n");
		
		/*String regex = "\\section\\{abstract\\}\\{(?<meuGrupo>.*?)\\}";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher comparator = pattern.matcher(text);

		if (comparator.find()) {
			this.text = comparator.group("meuGrupo");

		}*/
		Matcher matcher = PATTERN.matcher(t);

		if (matcher.matches() && matcher.groupCount() == 1) {
			this.text = matcher.group(1);
		} else {
			System.out.println("Não encontrou resumo.");
		}

	}

	private String text;
	
	private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*");
}
