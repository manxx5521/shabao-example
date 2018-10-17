package com.xiaoshabao.example.module.base.数据结构;

import java.util.function.Consumer;

public class LinkedTest<T> {

	private Node<T> start;
	private Node<T> end;

	public void add(T t) {
		Node<T> node = new Node<T>(t);
		if (end == null) {
			end = node;
			start = end;
		} else {
			end.next = node;
			end=node;
		}
	}
	
	public void removeFirst() {
		if(start==null) {
			return;
		}
		if(start.next==null) {
			start=null;
			end=null;
		}else {
			Node<T> node=start.next;
			start.next=null;
			start=node;
		}
	}
	
	public void forEach(Consumer<T> function) {
		if(start==null) {
			return;
		}
		Node<T> node =start;
		while(true) {
			function.accept(node.value);
			if(node.next==null) {
				return;
			}else {
				node=node.next;
			}
		}
	}
	
	/**
	 * 构造反转
	 */
	public  void reverse() {
		Node<T> pre = null;
        Node<T> post = null;
        while(start!=null) {
            post = start.next;//缓存下一节点
            start.next = pre;//当前节点脱离列表，并把已经反转好的 链接到当前节点
            if(pre==null) {
            	end=start;
            }
            pre = start;//把当前反转 转为历史 pre
            start = post;//移动操作节点到下一节点
        }
        start=pre;
	}
	/**
	 * 构造一个新的节点存储
	 */
	public  void reverse2() {
		Node<T> node=start;
		Node<T> sub=new Node<T>(node.value);
		end=sub;
		do {
			node=node.next;
			Node<T> p=new Node<T>(node.value,sub);
			sub=p;
		}while(node.next!=null);
		start=sub;
	}
	
	/**
	 * 只存下一节点，行程单向节点
	 */
	private static class Node<T> {

		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
		}
		Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
//		LinkedList<String> a;
		
		LinkedTest<String> linked=new LinkedTest<String>();
		linked.add("刘二");
		linked.add("张三");
		linked.add("李四");
		linked.add("王五");
		linked.forEach(t->{System.out.println(t);});
		
		System.out.println("反转---------------");
		linked.reverse();
		linked.forEach(t->{System.out.println(t);});
		
	}
}


