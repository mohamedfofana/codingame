package main.java.codingame.string;

import java.util.Stack;

public class StringParser {
	static boolean check(String str) {
		if (str == null || str.isEmpty()){
			return true;
		}
		if (str.startsWith(")") || str.startsWith("]") || str.endsWith("(") || str.endsWith("[")){
			return false;
		}
		int pOpen = 0;
		int cOpen = 0;
		Stack<String> dejaLu = new Stack<String>();

		for (int i = 0; i < str.length(); i++) {
			String c1 = Character.toString(str.charAt(i));
			if (c1.equals("(")){
				pOpen ++;
				dejaLu.push(c1);
			}
			else if (c1.equals(")")){
				if (pOpen == 0){
					return false;
				}else{
					pOpen--;
					if (dejaLu.peek().equals("(")){
						dejaLu.pop();
					}else{
						return false;
					}
				}
			}
			else if (c1.equals("[")){
				cOpen++;
				dejaLu.push(c1);
			}
			else if (c1.equals("]")){
				if (cOpen == 0){
					return false;
				}else{
					cOpen--;
					if (dejaLu.peek().equals("[")){
						dejaLu.pop();
					}else{
						return false;
					}
				}
			}
		}
		if (cOpen > 0 || pOpen>0){
			return false;
		}

		return true;
	}
}
