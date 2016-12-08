package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenization {
	public static void main(String[] args) {
//		String padraoSilabico = "ab";
//		String padraoNumerico = "\\b";
		
//		buscaRegex(padraoSilabico, "abbaab");
		regexNumeroHexadecimal("12 0x 0x12 0Xf 0xg");
//		buscaRegex(padraoNumerico, ".2w w$ a#w2");
	}
	
	public static void buscaRegex(String regex,String texto){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(texto);
		while(m.find())
			System.out.print(m.start()+"\t");
	}
	
	public static void regexNumeroHexadecimal(String texto){
		String regex = "0[xX][0-9a-fA-F]";
		buscaRegex(regex, texto);
	}
	
}
