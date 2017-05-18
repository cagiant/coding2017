package week7_0423;

import java.util.List;
import java.util.Stack;

public class PrefixExpr {
	String expr = null;
	
	public PrefixExpr(String expr) {
		this.expr = expr;
	}
	
	public float evaluate() {
		TokenParser parser = new TokenParser();
		List<Token> tokens = parser.parse(expr);
		
		Stack<Token> exprStack = new Stack();
		Stack<Float> numStack = new Stack();
		for (Token token: tokens) {
			exprStack.push(token);
		}
		while (!exprStack.isEmpty()) {
			if (exprStack.peek().isNumber()) {
				numStack.push(new Float(exprStack.pop().getIntValue()));
			} else if (exprStack.peek().isOperator()) {
				Float f1 = numStack.pop();
				Float f2 = numStack.pop();
				numStack.push(caculate(exprStack.pop().toString(), f1, f2));
			}
		}
		return numStack.pop().floatValue();
	}

	private Float caculate(String operator, Float f1, Float f2) {
		if (operator.equals("+")) {
			return f1 + f2;
		} else if (operator.equals("-")) {
			return f1 - f2;
		} else if (operator.equals("*")) {
			return f1 * f2;
		} else if (operator.equals("/")) {
			return f1 / f2;
		}
		throw new RuntimeException(operator + "is not supported");
	}
}
