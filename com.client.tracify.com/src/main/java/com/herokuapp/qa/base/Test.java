package com.herokuapp.qa.base;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Test {
	public static void main(String[] args) {
		String key = "ABHY1236Hhbgfako";// must be 16 digit
		String name = "harsh";
		String enc = encrypt(key, name);
		System.out.println("encrypt--" + enc);
		String dec = decrypt(key, enc.getBytes());
		System.out.println(dec);
	}

	public static String encrypt(String key, String text) {

		try {
			// Create key and cipher
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			return new String(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String decrypt(String key, byte[] encrypted) {
		String decrypted = "";
		try {
			// Create key and cipher
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			decrypted = new String(cipher.doFinal(encrypted));
			return decrypted;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}

