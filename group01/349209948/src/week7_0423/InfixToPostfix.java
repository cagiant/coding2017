package week7_0423;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
	
	public static List<Token> convert(String expr) {
		TokenParser parser = new TokenParser();
		List<Token> inFixTokens  = parser.parse(expr);
		List<Token> postTokens = new ArrayList<>();
		Stack<Token> tempStack = new Stack<Token>();
		for (Token token: inFixTokens) {
			if (token.isOperator()) {
				//若栈顶运算符优先级更高，则将其压栈
				while (!tempStack.isEmpty() && !token.hasHigherPriority(tempStack.peek())){
					postTokens.add(tempStack.pop());
				}
				tempStack.push(token);
			} else if (token.isNumber()) {
				postTokens.add(token);
			}
		}
		while (!tempStack.isEmpty()) {
			postTokens.add(tempStack.pop());
		}
		return postTokens;
	}
	
	

}
