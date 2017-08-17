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
	
	public String UTF8toISO(String str){
        Charset utf8charset = Charset.forName("UTF-8");
        Charset iso88591charset = Charset.forName("ISO-8859-1");

        ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

        // decode UTF-8
        CharBuffer data = utf8charset.decode(inputBuffer);

        // encode ISO-8559-1
        ByteBuffer outputBuffer = iso88591charset.encode(data);
        byte[] outputData = outputBuffer.array();

        return new String(outputData);
    }

	public String retiraCaracterEspecial(String texto) {
		String t1 = texto.replaceAll("%", "");
		String t2 = t1.replaceAll("&", "");
		return t2;
	}

}
