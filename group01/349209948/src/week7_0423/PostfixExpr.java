package week7_0423;

import java.util.List;
import java.util.Stack;

public class PostfixExpr {
	String expr = null;
	
	public PostfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		TokenParser parser = new TokenParser();
		List<Token> tokens = parser.parse(expr);
		
		Stack<Float> operandStack = new Stack();
		for (Token token: tokens) {
			if (token.isNumber()) {
				operandStack.push(new Float(token.getIntValue()));
			} else if (token.isOperator()) {
				Float f1 = operandStack.pop();
				Float f2 = operandStack.pop();
				operandStack.push(caculate(token.toString(), f1, f2));
			}
		}
		return operandStack.pop().floatValue();
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
