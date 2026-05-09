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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        for(ListNode list: lists){
            if(list != null){
                queue.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode curr = res;

        while(!queue.isEmpty()){
            ListNode currNode = queue.poll();

            curr.next = currNode;
            curr = curr.next;


            if(currNode.next != null){
                queue.add(currNode.next);
            }    
        }

        return res.next;
    }
}
