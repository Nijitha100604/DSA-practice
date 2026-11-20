package linked_list;

public class merge_k_sorted_list {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        return mergeLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeLists(ListNode[] lists, int left, int right){
        if(left == right)
            return lists[left];
        
        if(left + 1 == right)
            return merge(lists[left], lists[right]);

        int mid = left + (right - left) / 2;
        ListNode l = mergeLists(lists, left, mid);
        ListNode r = mergeLists(lists, mid+1, right);
        return merge(l, r);
    }

    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode ptr = result;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ptr.next = l1;
                l1 = l1.next;
            } else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if(l1 != null)
            ptr.next = l1;

        if(l2 != null)
            ptr.next = l2;

        return result.next;
    }

    public static void main(String[] args){

        // List 1: [1, 4, 5]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // List 2: [1, 3, 4]
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // List 3: [2, 6]
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Store all lists in an array
        ListNode[] lists = {l1, l2, l3};

        // Merge K sorted lists
        ListNode result = mergeKLists(lists);

        // Display result
        System.out.print("Merged List: ");

        ListNode curr = result;
        while(curr != null){
            System.out.print(curr.val);

            if(curr.next != null)
                System.out.print(" -> ");

            curr = curr.next;
        }

        System.out.println(" -> null");
    }
}
