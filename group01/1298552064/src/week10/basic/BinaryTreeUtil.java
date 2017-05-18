package week10.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import week09.basic.Queue;

public class BinaryTreeUtil {
	/**
	 * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root != null){
			result.add(root.getData());
			result.addAll(preOrderVisit(root.getLeft()));
			result.addAll(preOrderVisit(root.getRight()));
		}
		return result;
	}

	/**
	 * 用递归的方式实现对二叉树的中遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root != null){
			result.addAll(inOrderVisit(root.getLeft()));
			result.add(root.getData());
			result.addAll(inOrderVisit(root.getRight()));
		}
		return result;
	}

	/**
	 * 用递归的方式实现对二叉树的后遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root != null){
			result.addAll(postOrderVisit(root.getLeft()));
			result.addAll(postOrderVisit(root.getRight()));
			result.add(root.getData());
		}
		return result;
	}

	/**
	 * 用非递归的方式实现对二叉树的前序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {

		List<T> result = new ArrayList<T>();
		/*
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		while(root != null){
			result.add(root.getData());
			if(root.getRight() != null){
				stack.push(root.getRight());
			}
			root = root.getLeft();
			
		}
		
		while(!stack.isEmpty()){
			root = stack.pop();
			while(root != null){
				result.add(root.getData());
				if(root.getRight() != null){
					stack.push(root.getRight());
				}
				root = root.getLeft();
			}
		}*/
		
		/*
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			result.add(root.getData());
			if(root.getRight() != null){
				stack.push(root.getRight());
			}
			if(root.getLeft() != null){
				stack.push(root.getLeft());
			}
		}*/
		
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				result.add(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			
			root = stack.pop();
			root = root.getRight();
		}
		
		return result;
	}

	/**
	 * 用非递归的方式实现对二叉树的中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {

		List<T> result = new ArrayList<T>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			root = stack.pop();
			result.add(root.getData());
			root = root.getRight();
		}
		return result;
	}
	
	/**
	 * 用非递归的方式实现对二叉树的后序遍历
	 * 
	 * (用map记录已经访问过的节点，先处理左右子树，再回溯读取根节点)
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> postOrderWithoutRecursion(BinaryTreeNode<T> root) {
		
		List<T> result = new ArrayList<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		Map<BinaryTreeNode<T>, Boolean> visitedMap = new HashMap<>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.peek();
			if(root.getRight() != null && !visitedMap.containsKey(root.getRight())){
				stack.push(root.getRight());
			}
			if(root.getLeft() != null && !visitedMap.containsKey(root.getLeft())){
				stack.push(root.getLeft());
			}
		
			root = stack.peek();
			if(root.getLeft() != null && !visitedMap.containsKey(root.getLeft())){
				continue;
			}else if(root.getLeft() == null || visitedMap.containsKey(root.getLeft())){
				root = stack.pop();
				result.add(root.getData());
				visitedMap.put(root, true);
			}
		}
		return result;
	}
	
	/**
	 * 用非递归的方式实现对二叉树的层序列遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> leavelOrderVisit(BinaryTreeNode<T> root){
		List<T> result = new ArrayList<T>();
		Queue<BinaryTreeNode<T>> queue = new Queue<>();
		queue.enQueue(root);
		while(!queue.isEmpty()){
			root = queue.deQueue();
			result.add(root.getData());
			if(root.getLeft() != null){
				queue.enQueue(root.getLeft());
			}
			if(root.getRight() != null){
				queue.enQueue(root.getRight());
			}
		}
		return result;
	}
}
