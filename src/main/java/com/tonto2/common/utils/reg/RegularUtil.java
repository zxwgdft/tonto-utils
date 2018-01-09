package com.tonto2.common.utils.reg;

public class RegularUtil {

	private final static char[] escapeChars = { '\\', '$', '(', ')', '*', '+', '.', '[', ']', '?', '^', '{', '}', '|' };

	public static String escape(String regular) {

		if (regular == null)
			return null;

		char[] cs = regular.toCharArray();
		char[] newCs = new char[cs.length * 2];
		int j = 0;
		for (char c : cs) {
			for (char ec : escapeChars) {
				if (ec == c) {
					newCs[j++] = '\\';
					break;
				}
			}

			newCs[j++] = c;
		}

		return new String(newCs, 0, j);

	}

}
