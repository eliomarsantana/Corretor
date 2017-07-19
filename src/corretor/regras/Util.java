package corretor.regras;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.List;

import org.jbibtex.ParseException;

public class Util {

public String charset(String texto) throws CharacterCodingException{
		
		Charset charsetE = Charset.defaultCharset();
		CharsetEncoder encoder = charsetE.newEncoder();

		//i believe from here to the end will probably stay the same, as per your posted example.
		Charset charsetD = Charset.forName("UTF-8");
		CharsetDecoder decoder = charsetD.newDecoder();
		

		ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(texto));
		CharBuffer cbuf = decoder.decode(bbuf);
		//final String result = cbuf.toString();
		
		
		
		return cbuf.toString();
	}
	
	public String extractText(String text) throws ParseException{
		
		org.jbibtex.LaTeXParser latexParser = new org.jbibtex.LaTeXParser();

		List<org.jbibtex.LaTeXObject> latexObjects = latexParser.parse(text);

		org.jbibtex.LaTeXPrinter latexPrinter = new org.jbibtex.LaTeXPrinter();

		String plainTextString = latexPrinter.print(latexObjects);
		
		return plainTextString;
		
	}
	
	public String retiraCaracterEspecial(String texto){
		String t1 = texto.replaceAll("%", "");
		String t2 = t1.replaceAll("&", "");
		return t2;
	}

}
