package week10.tree.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import week10.tree.BinaryTreeNode;


public class BinaryTreeNodeTest {
	
	private BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(5);

	@Before
	public void setUp() throws Exception {
		root.insert(2);
		root.insert(7);
		root.insert(1);
		root.insert(6);
	}

	@Test
	public void testGetData() {
		Assert.assertEquals(root.getData().intValue(), 5);
		Assert.assertEquals(root.getLeft().getData().intValue(), 2);
		Assert.assertEquals(root.getRight().getData().intValue(), 7);
		Assert.assertEquals(root.getLeft().getLeft().getData().intValue(), 1);
		Assert.assertEquals(root.getRight().getLeft().getData().intValue(), 6);
	}

	@Test
	public void testSetData() {
		root.setData(8);
		Assert.assertEquals(root.getData().intValue(),8);
		root.getLeft().setData(88);
		Assert.assertEquals(root.getLeft().getData().intValue(),88);
		root.getRight().setData(888);
		Assert.assertEquals(root.getRight().getData().intValue(),888);
	}

	@Test
	public void testGetLeft() {
		BinaryTreeNode<Integer> node_left = root.getLeft();
		Assert.assertEquals(node_left.getData().intValue(), 2);
		BinaryTreeNode<Integer> node_left_left = root.getLeft().getLeft();
		Assert.assertEquals(node_left_left.getData().intValue(), 1);
	}

	@Test
	public void testSetLeft() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(100);
		root.setLeft(node);
		Assert.assertEquals(root.getLeft().getData().intValue(), 100);
	}

	@Test
	public void testGetRight() {
		BinaryTreeNode<Integer> node_right = root.getRight();
		Assert.assertEquals(node_right.getData().intValue(), 7);
		root.insert(8);
		BinaryTreeNode<Integer> node_right_right = root.getRight().getRight();
		Assert.assertEquals(node_right_right.getData().intValue(), 8);
	}

	@Test
	public void testSetRight() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(100);
		root.setRight(node);
		Assert.assertEquals(root.getRight().getData().intValue(), 100);
	}

	@Test
	public void testInsert() {
		root.insert(4);
		root.insert(8);
		Assert.assertEquals(root.getLeft().getRight().getData().intValue(), 4);
		Assert.assertEquals(root.getRight().getRight().getData().intValue(), 8);
	}

}
