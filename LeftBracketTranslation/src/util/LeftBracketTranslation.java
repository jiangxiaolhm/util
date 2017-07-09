package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class LeftBracketTranslation {
	public static String translation(String source) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(source));
		String result = "";
		String str = null;
		char[] arr;
		while ((str = br.readLine()) != null) {
			arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '<') {
					result += "&lt;";
				}
				else {
					result += arr[i];
				}
			}
			result += '\n';
		}
		br.close();
		return result;
	}
}
