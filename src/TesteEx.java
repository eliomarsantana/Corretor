import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteEx {

	public static void main(String[] args) {
		String t = "-Eliomar Santana de Jesus";
		System.out.println(isCampoNomeValido(t));

	}
	
	public static boolean isCampoNomeValido(String texto){
    	texto = texto.replaceAll("[`]","'");
        Pattern p = Pattern.compile("^[ \\p{L}'\"��.-]+$");
        Matcher m = p.matcher(texto);     
        return m.matches();     
    }  

}