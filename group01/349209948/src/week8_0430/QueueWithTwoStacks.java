package week8_0430;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * @author cary
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;    
    private Stack<E> stack2;    

    
    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

   
    

    public boolean isEmpty() {
        return stack1.isEmpty();
    }


    
    public int size() {
        return stack1.size();   
    }



    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
        int size1 = stack1.size();
        for (int i = 0;i < size1; i++) {
        	stack2.push(stack1.pop());
        }
        E data = stack2.pop();
        int size2 = stack2.size();
        for (int i = 0; i< size2;i ++) {
        	stack1.push(stack2.pop());
        }
        return data;
    }



 }

