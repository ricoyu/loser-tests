package com.loserico.codec;

import com.loserico.common.lang.utils.StringUtils;
import org.junit.Test;

/**
 * <p>
 * Copyright: (C), 2020/3/9 16:30
 * <p>
 * <p>
 * Company: Sexy Uncle Inc.
 *
 * @author Rico Yu ricoyu520@gmail.com
 * @version 1.0
 */
public class AesEncryptUtilsTest {
	
	@Test
	public void testAes() {
		String key = StringUtils.uniqueKey(16);
		String uri = "uri=/zl.mt.basic.getbasicdatainfo/1.0.0/action&timestamp=123123123123&cookie=asdkasdihqqnds";
		String encrypted = AesEncryptUtils.encrypt(uri, key);
		System.out.println(encrypted);
	}
	
	@Test
	public void testRsa() {
		RsaUtils.RsaKeyPair rsaKeyPair = RsaUtils.initRSAKey(2048);
		String uri = "uri=/zl.mt.basic.getbasicdatainfo/1.0.0/action&timestamp=123123123123&cookie=asdkasdihqqnds";
		String encrypted = RsaUtils.publicEncrypt(uri, rsaKeyPair.publicKey());
		System.out.println(encrypted);
		String decrypted = RsaUtils.privateDecrypt(encrypted, rsaKeyPair.privateKey());
		System.out.println(decrypted);
	}
}
