package dsa;

public class LinkedList { //Singly-Linked-List
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		head=null;
		tail=null;
	}

	// Node class for creating node object of singly linked list
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
		}
	}
	
	//insert function to insert node the inserted node will added at tail of List
	public void insert(int value) {
		Node n = new Node(value);
		if(head==null) {
			head=n;
			tail=n;
			size++;
		}
		else {
			tail.next=n;
			tail=n;
			size++;
		}
	}
	
	//insert function to insert node at given index 
	public void insertAtPosition(int index,int value) {
		if(index==0) {
			Node n = new Node(value);
			Node currentNode=head;
			n.next=currentNode;
			head=n;
			size++;
		}
		else {
			Node n = new Node(value);
			Node currentNode=head;
			while(index-->1) {
				currentNode=currentNode.next;
			}
			n.next=currentNode.next;
			currentNode.next=n;
			size++;
		}
		
	}
	
	//delete function to delete node at present in last Index or Tail 
	public void deleteLast() {
		Node currentNode = head;
		while(currentNode.next.next!=null) {
			currentNode=currentNode.next;
		}
		currentNode.next=null;
		tail=currentNode;
		size--;
	}
	
	//delete function to delete node at present in given index or position 
	public void deleteAtPosition(int index) {
		if(index==0) {
			Node currentNode=head.next;
			head.next=null;
			head=currentNode;
			size--;
		}
		else {
			Node currentNode = head;
			while(index-->1) {
				currentNode=currentNode.next;
			}
			currentNode.next=currentNode.next.next;
			size--;
		}
		
	}
	
	
	//function to display the LinkedList
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
