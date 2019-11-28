package com.loserico.hex;

import com.loserico.common.lang.codec.HexUtils;
import org.junit.Test;

/**
 * <p>
 * Copyright: (C), 2019/11/26 9:24
 * <p>
 * <p>
 * Company: Sexy Uncle Inc.
 *
 * @author Rico Yu ricoyu520@gmail.com
 * @version 1.0
 */
public class HashUtilsTest {
	
	@Test
	public void testInteger2Binary() {
		System.out.println(Integer.toBinaryString(214312));
		System.out.println(Integer.toBinaryString(123432));
		System.out.println(Integer.toBinaryString(16));
		System.out.println(2/8);
	}
	
	@Test
	public void testHex2Binary() {
		// 01111111 11111111 11111111 11111111
		System.out.println(HexUtils.hex2Binary("0x7fffffff"));;
	}
}
