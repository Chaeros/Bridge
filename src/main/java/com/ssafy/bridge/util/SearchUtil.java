package com.ssafy.bridge.util;

public class SearchUtil {

	private static SearchUtil searchUtil;

	private SearchUtil() {

	}

	public static SearchUtil getInstance() {
		if (searchUtil == null) {
			searchUtil = new SearchUtil();
		}
		return searchUtil;
	}

	public boolean isEqual(String target, String find) {

		char[] text = target.toCharArray();
		char[] pattern = find.toCharArray();

		int tLength = text.length, pLength = pattern.length;

		int[] pi = new int[pLength];
		for (int i = 1, j = 0; i < pLength; i++) {
			while (j > 0 && pattern[i] != pattern[j])
				j = pi[j - 1];

			if (pattern[i] == pattern[j])
				pi[i] = ++j;
			else
				pi[i] = 0;
		}

		for (int i = 0, j = 0; i < tLength; ++i) {

			while (j > 0 && text[i] != pattern[j])
				j = pi[j - 1];

			if (text[i] == pattern[j]) {
				if (j == pLength - 1) {
					return true;
				} else {
					j++;
				}
			}
		}
		return false;
	}
}
