package br.com.tcc.leilao.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class CryptoTest {
	
	@Test
	public void testEncrypt() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Crypto crypto = new Crypto();
		String encrypt = crypto.encrypt("asd147");
		System.out.println(encrypt);
	}
}
