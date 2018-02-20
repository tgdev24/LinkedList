import java.util.*;

public class MySingleLinkedList<E> implements Iterable<E>{
	Node head;
	
	public MySingleLinkedList(){
		head = new Node();
	}
	
	class Node{
		E data;
		Node next;
		
		public Node(){
			data = null;
			next = null;
		}
		
		public Node(E newData, int index) {
			Node current = head;
			int counter = 1;
			while(counter-1 != index) {
				current = current.next;
			}
			data = newData;
			this.next = current.next;
			current.next = this;
		}
	}
	
	//start methods
	public void addFirst(E item) {
		Node newone = new Node();
		newone.data = item;
		//empty list
		if(head == null) {
			head.next = newone;
			return;
		}
		//at least 1 element inside the list
		newone.next = head.next;
		head.next = newone;
	}
	
	public void change(E item, int index) {
		Node current = head.next;
		int counter = 0;
		while(counter != index) {
			current = current.next;
			counter++;
		}
		current.data = item;
	}
	
	public void traverse() {
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}
	
	public Iterator<E> iterator(){
		return new singleLinkedListIterator();
	}
	
	private class singleLinkedListIterator implements Iterator<E>{
		private Node nextNode;
		
		public singleLinkedListIterator() {
			nextNode = head.next;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextNode != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(hasNext() == false) {
				throw new NoSuchElementException();
			}
			E data = nextNode.data;
			nextNode = nextNode.next;
			return data;
		}
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
		System.out.println();
		list.addFirst("John");
		list.addFirst("Thomas");
		list.addFirst("Jackie");
		list.traverse();
		list.change("Ryan",2);
		System.out.println();
		list.traverse();
		System.out.println();
		Iterator itr1 = list.iterator();
	    while(itr1.hasNext()) {
	    		System.out.print(itr1.next() + " ");
	    }
	    System.out.println();
	}
}
