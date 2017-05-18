package week6_0416;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class InfixExpr {
	String expr = null;
	
	public InfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		float result = 0;
		
		Stack operandStack = new Stack(); //运算数
		Stack operatorStack = new Stack(); //运算符
		
		char[] exprCharArray = expr.toCharArray();
		List<String> exprStringList = new ArrayList<String>();
		addOperandAndOperator(exprCharArray, exprStringList);
		
		for (int i =0; i< exprStringList.size(); i ++) {
			if (isOperand(exprStringList.get(i))){
				operandStack.push(exprStringList.get(i));
			} else if (isOperator(exprStringList.get(i))) {
				operatorStack.push(exprStringList.get(i));
			} else {
				throw new RuntimeException("this operator has not been implemented yet");
			}
			if (operatorStack.size() == 2) {
				
				String operator_1 = (String) operatorStack.pop();
				String operator_2 = (String) operatorStack.pop();
				if (hasTheSameOrHighPriority(operator_2, operator_1)) {
					
					String operand_1 = (String)operandStack.pop();
					String operand_2 = (String)operandStack.pop();
					operation(operandStack, operand_1, operand_2, operator_2);
					
					operatorStack.push(operator_1);
				} else if (hasTheLowPriority(operator_2, operator_1)) {
					operandStack.push(exprStringList.get(++i));
					String operand_1 = (String)operandStack.pop();
					String operand_2 = (String)operandStack.pop();
					operation(operandStack, operand_1, operand_2, operator_1);
					operatorStack.push(operator_2);
				}
			}
			if (i == exprStringList.size() -1) {
				String operator = (String)operatorStack.pop();
				String operand_1 = (String)operandStack.pop();
				String operand_2 = (String)operandStack.pop();
				operation(operandStack, operand_1, operand_2, operator);
				result = (float)Integer.parseInt((String)operandStack.pop());
			}
		}
		return result;
	}


	public void addOperandAndOperator(char[] charArray, List<String> stringList) {
		for (int i =0; i< charArray.length; i++) {
			if (isOperand(charArray[i])) {
				StringBuilder sb = new StringBuilder();
				sb.append(charArray[i]);
				if (i < charArray.length -1) {
					while(i < charArray.length -1 && isOperand(charArray[i+1])) {
						sb.append(charArray[i+1]);
						i++;
					}
				}
				stringList.add(sb.toString());
			} else if (isOperator(charArray[i])) {
				stringList.add(charArray[i] + "");
			}
		}
	}
	
	public boolean isOperand(char c) {
		return !isOperator(c);
	}
	
	public boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}
		
	private boolean isOperand(String s) {
		return !isOperator(s);
	}

	private boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}
	
	
	private void operation(Stack operandStack, String operand_1, String operand_2, String operator) {
		if (operator.equals("+")) {
			operandStack.push((Integer.parseInt(operand_2) + Integer.parseInt(operand_1)) + "");
		} else if(operator.equals("-")) {
			operandStack.push((Integer.parseInt(operand_2) - Integer.parseInt(operand_1)) + "");
		} else if(operator.equals("*")) {
			operandStack.push((Integer.parseInt(operand_2) * Integer.parseInt(operand_1)) + "");
		} else if(operator.equals("/")) {
			operandStack.push((Integer.parseInt(operand_2) / Integer.parseInt(operand_1)) + "");
		}
		
	}
	
	private boolean hasTheSameOrHighPriority(String operator_1, String operator_2) {
		if ((operator_1.equals("+") && operator_2.equals("+")) || (operator_1.equals("+") && operator_2.equals("-"))
				|| (operator_1.equals("-") && operator_2.equals("+"))
				|| (operator_1.equals("-") && operator_2.equals("-"))
				|| (operator_1.equals("*") && operator_2.equals("*"))
				|| (operator_1.equals("*") && operator_2.equals("/"))
				|| (operator_1.equals("/") && operator_2.equals("*"))
				|| (operator_1.equals("/") && operator_2.equals("/"))
				|| (operator_1.equals("*") && operator_2.equals("+"))
				|| (operator_1.equals("*") && operator_2.equals("-"))
				|| (operator_1.equals("/") && operator_2.equals("+"))
				|| (operator_1.equals("/") && operator_2.equals("-"))) {
			return true;
		}
		return false;
	}
	
	private boolean hasTheLowPriority(String operator_1, String operator_2) {
		if (operator_1.equals("+") && operator_2.equals("*") || operator_1.equals("+") && 
				operator_2.equals("/") || operator_1.equals("-") && operator_2.equals("*") ||
				operator_1.equals("-") && operator_2.equals("/")) {
			return true;
		}
		return false;
	}

}
