package corretor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resumo {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		String regex = "\\section\\{abstract\\}\\{(?<meuGrupo>.*?)\\}";

	    Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
	    Matcher comparator = pattern.matcher(text);
	    
	    if(comparator.find()){
	    	this.text = comparator.group("meuGrupo");
	        
	    }
	}
	
	
}
