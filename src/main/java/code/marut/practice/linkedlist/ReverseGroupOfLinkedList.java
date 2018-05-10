package code.marut.practice.linkedlist;

/*
Reverse a Linked List in groups of given size.
 */

public class ReverseGroupOfLinkedList {
	Node head;
	private static class Node{
		public Node(int data){
			this.data = data;
		}
		public int data;
		public Node next;
		@Override
		public String toString() {
			return ""+data;
		}
	}
		
	public static Node reverseGroup(Node head, int k){
		
		Node cur = head;
		Node next = null;
		Node prev = null;
		int count=0;
		while(count <k && cur!=null){
			next = cur.next;
			cur.next=prev;
			prev= cur;
			cur = next;
			count++;
		}
		System.out.println(prev.data);
		if(next!=null){
			head.next=reverseGroup(next, k);
		}
		return prev;
	}
	
	public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
    	ReverseGroupOfLinkedList llist = new ReverseGroupOfLinkedList();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.head = llist.reverseGroup(llist.head, 3);
 
        System.out.println("Reversed list");
        llist.printList();
    }
	
}
