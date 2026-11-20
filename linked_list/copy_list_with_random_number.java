package linked_list;

/* 
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
 

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
*/

public class copy_list_with_random_number {

    public static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node newHead = head.next;
        curr = head;
        Node newCurr = curr.next;

        while(curr != null){
            curr.next = newCurr.next;
            curr = curr.next;

            if(curr != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
            
        }
        
        return newHead;
    }

    public static void display(Node head){
        Node curr = head;

        while(curr != null){
            System.out.print("[" + curr.val + ", ");

            if(curr.random != null)
                System.out.print(curr.random.val);
            else
                System.out.print("null");

            System.out.print("] -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args){
        // Creating original linked list
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Creating random pointers
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println("Original Linked List:");
        display(head);

        // Copying the linked list
        Node copyHead = copyRandomList(head);

        System.out.println("\nCopied Linked List:");
        display(copyHead);
    }
}
