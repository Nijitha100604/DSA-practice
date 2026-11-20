package linked_list;

/* 
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []
*/

public class reverse_linked_list {

    public static class ListNode{
        int val;
        ListNode next;
        
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode currNode = head;
        ListNode prevNode = null;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;

        return head;
    }

    public static void display(ListNode head){
        if(head == null){
            System.out.println("null");
            return;
        }
        
        ListNode curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseList(head);
        display(head);
    }
}
