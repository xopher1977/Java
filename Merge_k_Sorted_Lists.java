/*
  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

  Merge all the linked-lists into one sorted linked-list and return it.
*/

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
    //Time:  O(n) |  Space:  O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        
        //if 'lists' is empty, nothing to merge, return null
        if (lists.length == 0){
            return null;
        }
        
        //if only one list, then return the already sorted list
        if (lists.length == 1){
            return lists[0];
        }
        
        ListNode result = new ListNode();  //this is what will store the result ListNode list;
        
        //Priority Queue is a min heap in java, so use this min heap to always guarentee the top of the pQueue is the minimum value (by first element)
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(Comparator.comparingInt(a -> a.val));
        
        
        //each list in the lists array is already sorted, so the first step is to just add them all to the priority queue
        //the logic behind the priority queue will automatically handle the sorting so that the min of all the first indexes is at front of queue...
        // for example lists = [[1,4,5],[1,3,4],[2,6]],
        // the pQueue will look like this in tree form after below loop completes...
        //            [1,4,5]
        //            /     \
        //      [1,3,4]    [2,6]
        for (ListNode head : lists){
            if (head!=null){
                pQueue.add(head);
            }
        }
        
        ListNode current = result;  //create new pointer to point to result pointer.  current is what will be used to add values
        
        
        while (!pQueue.isEmpty()){   //while there are still nodes to process in Priority Queue
            ListNode head = pQueue.poll();    //get top of pQueue and create new ListNode with that value
            current.next = new ListNode(head.val);  //point the current pointer's .next pointer to the new head.
            current=current.next;   //move current pointer to its next value.
            
            if (head.next!=null){    //if head not yet empty....
              /*  //DEBUG STATMENT   
                   System.out.print("\n adding ... ");
                showList(head.next);
                */
               
               pQueue.add(head.next);  //add the remaining head back to to pQueue, 
                                       //again, Priority Queue will handle sorting. to ensure minimum is always at top
                //Example: after [1,4,5] is removed from pQueue, adding head.next back to pQueue will add [4,5] so resulting pQueue will now look like:
                   
                    //            [1,3,4]
                   //             /     \
                   //           [2,6]  [4,5]* (*ListNode [4,5] is the remainder of the list that was just removed from pQueue)
                
              /*   DEBUG STATEMENT  
                   System.out.print("New Top:  "); 
                   showList(pQueue.peek());
              */
            }
            
            
        }
        
        return result.next;  //result is currently pointing to 0, so return result.next to get the sorted list;
    }
    
    public static void showList(ListNode head){
        ListNode it = head;
        while (it!=null){
            System.out.print(it.val + " ");
            it = it.next;
        }
        
        System.out.println();
    }
}
