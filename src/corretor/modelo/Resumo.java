package corretor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resumo {

	private String text;

	public String getText() {
		return text;
	}

	//private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}([a-z0-9\\-]+).+\\\\end\\{abstract\\}.*");
	private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*");
	//(?<resumo>.+?)
	public void setText(String text) {
		
		
		String resume = text.replace("\\", "\\\\");//escapando as barras no arquivo
		String t = resume.replace("\n", "\\n");

		Matcher matcher = PATTERN.matcher(t);
		
		if(matcher.matches() && matcher.groupCount() == 1){
			this.text = matcher.group(1);
			System.out.println(getText());
		} else {
            System.out.println("Não encontrou resumo.");
        }
	   
	}
	public String getName(){
		return "Abstract";
	}
	
}
