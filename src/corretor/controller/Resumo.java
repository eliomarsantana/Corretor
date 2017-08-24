package corretor.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resumo {
	
	public Resumo(String text){
		this.text = text;
	}
	
	private String text;

	public String getResumo() {
		return text;
	}

		//private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}([az09\\]).\\\\end\\{abstract\\}.*");
	 	private static final Pattern PATTERN = Pattern.compile(".*\\\\begin\\{abstract\\}(.*)\\\\end\\{abstract\\}.*");
	 	//(?<resumo>.?)
	  	public void setResumo(String text) {
	 		String regex = "\\section\\{abstract\\}\\{(?<meuGrupo>.*?)\\}";
	 		
	 		
	 		String resume = text.replace("\\", "\\\\");//escapando as barras no arquivo
	 		String t = resume.replace("\n", "\\n");
	  
	 	    Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
	 	    Matcher comparator = pattern.matcher(text);
	 	    
	 	    if(comparator.find()){
	 	    	this.text = comparator.group("meuGrupo");
	 	        
	 	    }
	 		Matcher matcher = PATTERN.matcher(t);
	 		
	 		if(matcher.matches() && matcher.groupCount() == 1){
	 			this.text = matcher.group(1);
	 		} else {
	             System.out.println("Não encontrou resumo.");
	         }
	 	   
	 	}
}
