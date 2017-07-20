package com.cervus.nippon.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lg {
	private static final Logger logger = LoggerFactory.getLogger(Lg.class);

	public static void e(String str) {
		if (Constants.DEBUG) {
			logger.error(str);
		}
	}

	public static void i(String str) {
		if (Constants.DEBUG) {
			logger.info(str);
		}
	}

	public static void w(String str) {
		if (Constants.DEBUG) {
			logger.warn(str);
		}
	}

}
