package com.ssafy.bridge.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptUtil {
	
	private static EncryptUtil encrypt = new EncryptUtil();
	public static EncryptUtil getInstance() {
		return encrypt;
	}
	
	public String getSalt() {
		SecureRandom r = new SecureRandom();
		byte[] salt = new byte[20];
		r.nextBytes(salt);
		StringBuffer sb = new StringBuffer();
		for ( byte b : salt ) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	public String getEncrypt(String pwd, String salt) {
		String result = "";
		String serverSalt = "chanho";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			System.out.println("pwd + slat 적용 전 : " + pwd + ", " + salt);
			md.update((pwd+salt+serverSalt).getBytes());
			byte[] pwdsalt = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for ( byte b : pwdsalt ) {
				sb.append(String.format("%02x", b));
			}
			result = salt+"."+sb.toString();
			System.out.println("pwd + slat 적용 후 : " + result);
		}
		catch(NoSuchAlgorithmException e ) {
			e.printStackTrace();
		}
		return result;
	}
}
