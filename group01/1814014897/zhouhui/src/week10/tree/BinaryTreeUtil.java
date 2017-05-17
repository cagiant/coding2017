package week10.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {
	/**
	 * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new RuntimeException("Error:this BinaryTree is null.");
		}
		List<T> result = new ArrayList<T>();

		result.add(root.getData());
		if (root.getLeft() != null) {
			result.addAll(preOrderVisit(root.getLeft()));
		}
		if (root.getRight() != null) {
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
		if (root == null) {
			throw new RuntimeException("Error:this BinaryTree is null.");
		}
		List<T> result = new ArrayList<T>();

		if (root.getLeft() != null) {
			result.addAll(inOrderVisit(root.getLeft()));
		}
		result.add(root.getData());
		if (root.getRight() != null) {
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
		if (root == null) {
			throw new RuntimeException("Error:this BinaryTree is null.");
		}
		List<T> result = new ArrayList<T>();

		if (root.getLeft() != null) {
			result.addAll(postOrderVisit(root.getLeft()));
		}
		if (root.getRight() != null) {
			result.addAll(postOrderVisit(root.getRight()));
		}
		result.add(root.getData());
		
		return result;
	}

	/**
	 * 用非递归的方式实现对二叉树的前序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new RuntimeException("Error:this BinaryTree is null.");
		}
		List<T> result = new ArrayList<T>();
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			result.add(root.getData());
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
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
		if (root == null) {
			throw new RuntimeException("Error:this BinaryTree is null.");
		}
		List<T> result = new ArrayList<T>();
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

		BinaryTreeNode<T> node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}

			if (!stack.isEmpty()) {
				node = stack.pop();
				result.add(node.getData());
				node = node.getRight();
			}

		}

		return result;
	}

}
