package corretor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Title {

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
<<<<<<< HEAD
	}
	
	public String getName(){
		return "Title";
=======
>>>>>>> 5478797a2f06392f60af50417dc673ca0d3a00a0
	}
	
	public String getName(){
		return "Title";
	}
	
}
