package week7_0423;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Token {
	public static final List<String> operator = Arrays.asList("+","-","*","/");
	public static final Map<String, Integer> priorities = new HashMap<>();
	static {
		priorities.put("+", 1);
		priorities.put("-", 1);
		priorities.put("*", 2);
		priorities.put("/", 2);
	}
	static final int operatorType = 1;
	static final int numberType = 2;
	String value;
	int type;
	public Token(int type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public boolean isOperator(){
		return type == operatorType;
	}
	
	public boolean isNumber() {
		return type == numberType;
	}
	
	public int getIntValue() {
		return Integer.valueOf(value).intValue();
	}
	
	public String toString() {
		return value;
	}
	
	public boolean hasHigherPriority(Token t) {
		if (!this.isOperator() && !t.isOperator()) {
			throw new RuntimeException("numbers can not compare priority");
		}
		return priorities.get(this.value) - priorities.get(t.value) > 0;
	}
}
