/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode low = new ListNode(0);
        ListNode lowDummy = low;
        ListNode high = new ListNode(0);
        ListNode dummy = high;
        while(temp != null){
            if(temp.val < x){
                low.next = temp;
                temp = temp.next;
                low = low.next;
            }
            else{
                high.next = temp;
                temp = temp.next;
                high = high.next;
            }
        }
        low.next = dummy.next;
        high.next = null;
        return lowDummy.next;
    }
}