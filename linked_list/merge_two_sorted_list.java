package linked_list;

/* 
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
*/

public class merge_two_sorted_list {

    public static class ListNode{
        int val;
        ListNode next;
        
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode l1 = list1, l2 = list2;
        ListNode head = result;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                result.next = l1;
                l1 = l1.next;
            } else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if(l1 == null){
            result.next = l2;
        }

        if(l2 == null)
            result.next = l1;

        return head.next;
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

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(7);

        ListNode head = mergeTwoLists(head1, head2);
        display(head);
    }
}
