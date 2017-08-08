package corretor.controller;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Util {

	public String charset(String texto) throws CharacterCodingException {

		Charset charsetE = Charset.defaultCharset();
		CharsetEncoder encoder = charsetE.newEncoder();

		Charset charsetD = Charset.forName("UTF-8");
		CharsetDecoder decoder = charsetD.newDecoder();

		ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(texto));
		CharBuffer cbuf = decoder.decode(bbuf);

		return cbuf.toString();
	}

	public String retiraCaracterEspecial(String texto) {
		String t1 = texto.replaceAll("%", "");
		String t2 = t1.replaceAll("&", "");
		return t2;
	}

}
