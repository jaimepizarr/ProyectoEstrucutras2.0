/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author soyjosephavila
 */
public class CircularLinkedList{
	static class Node{
		int key;    //Data value
		Node next;  //points to next element in the list.

		public Node(int data){
			this.key=data;
			this.next=null;
		}

	}

	public Node head;   //head of the list.

	public CircularLinkedList(){
		head=null;
	}

     public void pushFront(int number){
		System.out.println("Inserting data at front : " + number);
		Node node = new Node(number);
		if(head==null){
			head=node;
			node.next=head;
			return;
		}
		
	
		if(head.next==head){
			node.next=head;
			head=node;
			node.next.next=head; 
			return;
		}
		
		Node temp=head;
		while(temp.next!=head){
			temp=temp.next;
		}

		node.next=head;
		head=node;
		temp.next=head;  
	}
		
		

	 public void pushBack(int number){
		System.out.println("Inserting data at back  : " + number);
		Node node = new Node(number);
	
		if(head==null){
			head=node;
			node.next=head;
			return;
		} 		
	
		//if list contains only single element.	
		if(head.next==head){
			head.next=node;
			node.next=head;
			return;
		}
		Node temp = head;
		while(temp.next!=head){
			temp=temp.next;
		}
		temp.next=node;
		node.next=head;
	}

	
	public  void popFront(){
		System.out.print("PopFront Operation : ");
		if(head==null){
			System.out.println("Empty List.");
			return;
		}

		if(head.next==head){
			head=null;
			System.out.println("Successfull.");
			return;
		}
		
		Node temp=head;
		while(temp.next!=head){
			temp=temp.next;
		}
		head=head.next;
		temp.next=head;  
		System.out.println("Successfull.");
	}

	//function to remove elements from the back of the list.
	public  void popBack(){
		System.out.print("PopBack Operation  : ");
		if(head==null){
			System.out.println("Empty List.");
			return;
		}
		
		if(head.next==head){
			head=null;
			System.out.println("Successfull.");
			return;
		}

		Node temp=head;
		while(temp.next.next!=head){
			temp=temp.next;
		}
		temp.next=temp.next.next; 
	}

	
	public  void display(){
		if(head==null){
			System.out.println("Empty List.");
			return;
		}

		Node temp=head;
		while(temp.next!=head){
			System.out.print(temp.key + " ");
			temp=temp.next;
		}
		System.out.println(temp.key);
	}
}

