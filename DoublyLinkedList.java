package dsa;

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoublyLinkedList() {
		head=null;
		tail=null;
	}

	// Node class for creating node object of singly linked list
	class Node{
		int data;
		Node next;
		Node previous;
		
		public Node(int data) {
			this.data=data;
		}
	}
	
	//insert function to insert node the inserted node will added at tail of List
	public void insert(int value) {
		Node n = new Node(value);
		if(head==null) {
			head=n;
			head.previous=null;
			tail=n;
			size++;
		}
		else {
			tail.next=n;
			n.previous=tail;
			tail=n;
			size++;
		}
	}
	
	//insert function to insert node the inserted node will added at tail of List
	public void insertLast(int value) {
		Node n = new Node(value);
		Node currentNode=tail;
		currentNode.next=n;
		n.previous=currentNode;
		n.next=null;
		tail=n;
		
	}
	
	//insert function to insert node at given index 
	public void insertAtPosition(int index,int value) {
		if(index==0) {
			Node n = new Node(value);
			Node currentNode=head;
			n.next=currentNode;
			head=n;
			currentNode.previous=n;
			size++;
		}
		else if(index==size-1) {
			insertLast(value);
		}
		else {
			Node n = new Node(value);
			Node currentNode=head;
			while(index-->1) {
				currentNode=currentNode.next;
			}
			n.next=currentNode.next;
			n.previous=currentNode;
			currentNode.next=n;
			currentNode.next.previous=n;
			size++;
		}
		
		
	}
	
	//delete function to delete node at present in last Index or Tail
	public void deleteLast() {
		Node currentNode = tail;
		tail=currentNode.previous;
		tail.next=null;
		currentNode.previous=null;
		size--;
	}
	
	//delete function to delete node at present in given index or position
	public void deleteAtPosition(int index) {
		if(index==0) {
			Node currentNode=head.next;
			head.next=null;
			currentNode.previous=null;
			head=currentNode;
			size--;
		}
		else {
			Node currentNode = head;
			while(index-->1) {
				currentNode=currentNode.next;
			}
			currentNode.next=currentNode.next.next;
			currentNode.next.next.previous=currentNode;
			size--;
		}
		
	}
	
	//function to display the DoublyLinkedList
	public String toString() {
		Node currentNode=head;
		String s="";
		while(currentNode!=null) {
			s=s+currentNode.data+" ";
			currentNode=currentNode.next;
		}
		System.out.println(s);
		return ""; 
	}
	
	//function to get the size of list
		public int getSize() {
			return size;
		}

}
