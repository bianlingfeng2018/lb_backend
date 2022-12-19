package com.libiao.customer.util.des;

import java.security.MessageDigest;


public class Md5Util {

	public static String encrypt(String message) throws Exception {
		return encrypt(message, "MD5");
	}

	// algorithm: MD5 or SHA-1
	// return string length: 32 if algorithm = MD5, or 40 if algorithm = SHA-1
	public static String encrypt(String message, String algorithm)
			throws Exception {
		if (message == null) {
			throw new Exception("message is null.");
		}
		if (!"MD5".equals(algorithm) && !"SHA-1".equals(algorithm)) {
			throw new Exception("algorithm must be MD5 or SHA-1.");
		}
		byte[] buffer = message.getBytes();

		MessageDigest md = MessageDigest.getInstance(algorithm);

		md.reset();

		md.update(buffer);

		byte[] digest = md.digest();

		StringBuffer hexString = new StringBuffer();
		String sHexBit = null;
		for (int i = 0; i < digest.length; i++) {
			sHexBit = Integer.toHexString(0xFF & digest[i]);
			if (sHexBit.length() == 1) {
				sHexBit = "0" + sHexBit;
			}
			hexString.append(sHexBit);
		}
		return hexString.toString();
	}
	
	public static boolean checkPasswordByMd5(String inputPassword, String storagePassWord)
			throws Exception {
		boolean bool = true;

		String salts = "";
		String salttmp[] = salts.split(",");
		byte[] salt = new byte[salttmp.length];
		for (int i = 0; i < salt.length; i++) {
			salt[i] = Byte.parseByte(salttmp[i]);
		}
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(salt);
		m.update(inputPassword.getBytes("UTF8"));
		byte s[] = m.digest();
		String result = "";
		for (int i = 0; i < s.length; i++) {
			result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
					.substring(6);
		}
		/* �������ժҪ�Ƿ�ƥ�� */
		if (result.equals(storagePassWord)) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}
	 public static void main(String args[ ]) throws Exception{
		System.out.print(encrypt(encrypt("111111").substring(0, 24)));

	 }
}
