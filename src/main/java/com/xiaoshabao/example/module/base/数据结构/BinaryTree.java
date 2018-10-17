package com.xiaoshabao.example.module.base.数据结构;

import java.util.Comparator;

import com.xiaoshabao.example.module.base.数据结构.TreePrintUtil.TreeNode;

/**
 * 二叉树 左侧放入小值，右侧放入大值
 */
public class BinaryTree<E> {

	Node<E> root;

	Comparator<E> comparator;

	public BinaryTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public void add(E e) {
		if (root == null) {
			root = new Node<E>(e);
		} else {
			addElement(e, root);
		}
	}

	private void addElement(E e, Node<E> node) {
		int i = comparator.compare(e, node.value);
		if (i >= 0) {
			if (node.right == null) {
				node.right = new Node<E>(e);
			} else {
				addElement(e, node.right);
			}
		} else {
			if (node.left == null) {
				node.left = new Node<E>(e);
			} else {
				addElement(e, node.left);
			}
		}
	}

	public void remove(E e) {
		remove(e,root);
	}

	/**
	 * 删除元素
	 * @param e 要删除的元素
	 * @param node 从哪个节点开始
	 * @return
	 */
	public boolean remove(E e, Node<E> node) {
		if (node.value.equals(e)) {
			removeNode(node);
			return true;
		} else {
			//根据排序查询
			if(comparator.compare(e, node.value)>=0&&node.right!=null) {
				return remove(e, node.right);
			}else if(node.left!=null){
				return remove(e, node.left);
			}
			
			/*
			//以下代码是全遍历
			if(node.left!=null) {
				if(node.left.value.equals(e)) {
					removeNode(node.left);
					return true;
				}else {
					return remove(e, node.left);
				}
			}else if(node.right!=null){
				if(node.right.value.equals(e)) {
					removeNode(node.right);
					return true;
				}else {
					return remove(e, node.right);
				}
			}*/
		}
		return false;
	}
	
	/**
	 * 去除当前节点
	 */
	private void removeNode(Node<E> node) {
		if(node.left!=null) {
			node.value=removeMax(node.left,node);
		}else if(node.right!=null){
			node.value=removeMin(node.right,node);
		}else {
			node=null;
		}
	}
	
	/**
	 * 去除当前节点下的 最大值
	 * @return 返回最大节点的值
	 */
	private E removeMax(Node<E> node,Node<E> parent) {
		
		//如果右侧没有更大的值表示当前值 最大
		if(node.right==null) {
			
			//清空最大节点
			if(parent!=null) {
				parent.right=null;
			}
			return node.value;
		}
		return removeMax(node.right,node);
	}
	
	/**
	 * 去除当前节点下的 最小值
	 * @return 返回最大节点的值
	 */
	private E removeMin(Node<E> node,Node<E> parent) {
		
		//如果右侧没有更大的值表示当前值 最大
		if(node.left==null) {
			
			//清空最大节点
			if(parent!=null) {
				parent.left=null;
			}
			return node.value;
		}
		return removeMin(node.left,node);
	}
	
	
	

	public void print() {
		TreePrintUtil.pirnt(root);
	}

	private static class Node<E> implements TreeNode {
		E value;
		Node<E> left;
		Node<E> right;

		public Node(E value) {
			this.value = value;
		}
		/*
		public Node(E value, Node<E> left, Node<E> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}*/

		@Override
		public String getPrintInfo() {
			return "[" + value + "]";
		}

		@Override
		public TreeNode getLeftChild() {
			return left;
		}

		@Override
		public TreeNode getRightChild() {
			return right;
		}

	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>((e2, e1) -> {
			return e2.compareTo(e1);
		});
		tree.add(50);
		tree.add(30);
		tree.add(10);
		// tree.add(80);
		// tree.add(100);
		tree.add(40);
		tree.add(20);
		// tree.add(78);
		tree.add(15);
		
		tree.remove(10);
		tree.print();
		
		
	}

}
