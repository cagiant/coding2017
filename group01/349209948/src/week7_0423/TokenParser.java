package week7_0423;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {
	
	public List<Token> parse(String expr) {
		List<Token> tokens = new ArrayList();
		int i = 0;
		while(i < expr.length()) {
			char c = expr.charAt(i);
			if (isOperator(c)) {
				Token t = new Token(Token.operatorType, String.valueOf(c));
				tokens.add(t);
				i++;
			} else if (Character.isDigit(c)) {
				int nextOperatorIndex = getNextOperatorIndex(i, expr);
				String value = expr.substring(i, nextOperatorIndex);
				Token t = new Token(Token.numberType, value);
				tokens.add(t);
				i++;
			} else {
				System.out.println("["+c+"] is not a number nor an operator, ignore.");
			}
		}
		return tokens;
	}
	
	private int getNextOperatorIndex(int i, String expr) {
		while(Character.isDigit(expr.charAt(i))) {
			i++;
			if (i == expr.length()) {
				break;
			}
		}
		return i;
	}

	public boolean isOperator(char c) {
		String sc = String.valueOf(c);
		return Token.operator.contains(sc);
	}
}
